package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {


    @Test
    public void test01(){

        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin. (slayt sayfa 125)

        Response Body
        {
        "status": "success",
        "data": {
            "id": 3,
            "employee_name": "Ashton Cox",
            "employee_salary": 86000,
            "employee_age": 66,
            "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }

         */

        // 1- endpoint ve request body oluştur

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- expected data oluştur

        JSONObject dataBilgileriJsonObjesi = new JSONObject();
        dataBilgileriJsonObjesi.put("id",3);
        dataBilgileriJsonObjesi.put("employee_name","Ashton Cox");
        dataBilgileriJsonObjesi.put("employee_salary",86000);
        dataBilgileriJsonObjesi.put("employee_age",66);
        dataBilgileriJsonObjesi.put("profile_image","");

        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("message","Successfully! Record has been fetched.");
        expectedData.put("data",dataBilgileriJsonObjesi);

        // 3- request gönderip dönen response'i kaydet

        Response response = given().when().get(url);

        // 4- assertion

        // öncelikle response üzerindeki bilgileri kolay almak için JsonPath ' e çevirelim
        JsonPath responseJsonPath = response.jsonPath();

        // soft assert yapabilmek için soft assert objesi olusturalım
        SoftAssert softAssert = new SoftAssert();

        //TestNG soft assert te önce response actual , sonra expected yazılıyor

        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));


        softAssert.assertEquals(responseJsonPath.get("data.id"),
                expectedData.getJSONObject("data").get("id"));

        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),
                expectedData.getJSONObject("data").get("employee_name"));

        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),
                expectedData.getJSONObject("data").get("employee_salary"));

        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),
                expectedData.getJSONObject("data").get("employee_age"));

        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),
                expectedData.getJSONObject("data").get("profile_image"));


        // bu ifadeyi kullanmassak yapılan testlerde hata olsa bile raporlama yapmaz
        softAssert.assertAll();



    }


}
