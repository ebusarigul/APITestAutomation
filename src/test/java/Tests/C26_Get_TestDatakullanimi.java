package Tests;

import TestDatalari.TestDatalariDummy;
import baseUrl.BaseUrlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDatakullanimi extends BaseUrlDummy {

      /*
           http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
           gonderdigimizde donen response'un status code'unun 200,content type'inin
           application/json ve body'sinin asagidaki gibi oldugunu test edin. (slayt sayfa 150, video 25)

           Expected Response Body
           {
           "status":"success",
           "data":{
                 "id":3,
                 "employee_name":"Ashton Cox",
                 "employee_salary":86000,
                 "employee_age":66,
                 "profile_image":"",
                 },
           "message":"Successfully! Record has been fetched."
           }
     */


    @Test
    public void test01(){


        // 1- endpoint ve request body oluştur

        specDummyExample.pathParams("pp1","employee","pp2",3);

        // 2- expected data oluştur

        JSONObject expectedData = TestDatalariDummy.JsonResponseBodyOlustur(3,"Ashton Cox",86000,66,"");

        // 3- request gönder ve dönen response'i kaydet

        Response response = given()
                                  .when().spec(specDummyExample)
                                  .get("/{pp1}/{pp2}");

        // 4- assertion

        // Expected data: JSONObject
        // response: JsonPath

        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(TestDatalariDummy.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDatalariDummy.contentType,response.contentType());

        // data alanındaki değerleri kontrol et

        assertEquals(expectedData.getJSONObject("data").getInt("id")
                                                           ,responseJsonPath.getInt("data.id"));

        assertEquals(expectedData.getJSONObject("data").getString("employee_name")
                                                           ,responseJsonPath.getString("data.employee_name"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary")
                                                           ,responseJsonPath.getInt("data.employee_salary"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_age")
                                                           ,responseJsonPath.getInt("data.employee_age"));

        assertEquals(expectedData.getJSONObject("data").getString("profile_image")
                                                           ,responseJsonPath.getString("data.profile_image"));

        // message değerini kontrol et
        assertEquals(expectedData.getString("message"),responseJsonPath.getString("message"));
        // status değerini kontrol et
        assertEquals(expectedData.getString("status"),responseJsonPath.getString("status"));






    }


}
