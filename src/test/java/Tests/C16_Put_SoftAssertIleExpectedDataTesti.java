package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01(){

        /*

        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
        request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin. (slayt sayfa 127)

        Request Body
        {
        "status": "success",
        "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40
            }
        }


        Response Body
      { "status": "success",
        "data": {
            "status": "success",
            "data": {
                "name": “Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40 }
        },
        "message": "Successfully! Record has been updated."
      }

         */

        // 1- endpoint ve request body oluştur

        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject dataBilgileriJsonObjesi = new JSONObject();
        dataBilgileriJsonObjesi.put("name","Ahmet");
        dataBilgileriJsonObjesi.put("salary","1230");
        dataBilgileriJsonObjesi.put("age","44");
        dataBilgileriJsonObjesi.put("id",40);

        JSONObject requestBody = new JSONObject();
        requestBody.put("status","success");
        requestBody.put("data",dataBilgileriJsonObjesi);


        // 2- expected data oluştur

        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("message","Successfully! Record has been updated.");
        expectedData.put("data",requestBody);


        // 3- request gönderip dönen response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().body(requestBody.toString())
                                   .put(url);

        // 4- assertion

        // öncelikle response üzerindeki bilgileri kolay almak için JsonPath ' e çevirelim
        JsonPath responseJsonPath = response.jsonPath();

        // soft assert yapabilmek için soft assert objesi olusturalım
        SoftAssert softAssert = new SoftAssert();

        //TestNG soft assert te önce response actual , sonra expected yazılıyor
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));

        softAssert.assertEquals(responseJsonPath.get("data.status")
                               ,expectedData.getJSONObject("data").get("status"));

        softAssert.assertEquals(responseJsonPath.get("data.data.name")
                               ,expectedData.getJSONObject("data").getJSONObject("data").get("name"));

        softAssert.assertEquals(responseJsonPath.get("data.data.salary")
                               ,expectedData.getJSONObject("data").getJSONObject("data").get("salary"));

        softAssert.assertEquals(responseJsonPath.get("data.data.age")
                               ,expectedData.getJSONObject("data").getJSONObject("data").get("age"));

        softAssert.assertEquals(responseJsonPath.get("data.data.id")
                               ,expectedData.getJSONObject("data").getJSONObject("data").get("id"));



        // bu ifadeyi kullanmassak yapılan testlerde hata olsa bile raporlama yapmaz
        softAssert.assertAll();



    }

}
