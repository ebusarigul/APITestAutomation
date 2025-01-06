package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import TestDatalari.TestDatalariDummy;
import baseUrl.BaseUrlDummy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_Deserialization extends BaseUrlDummy {

           /*
                http:dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
                gonderdigimizde donen response'un status code'unun 200,content type'inin
                application/json ve body'sinin asagidaki gibi oldugunu test edin. (slayt sayfa 161) (video 28)

                Response Body
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


        // 1.endpoint ve request body olustur

        specDummyExample.pathParams("pp1","employee","pp2",3);

        // 2. expected data olustur(soruda varsa)

        Map<String ,Object> expectedDataMap = TestDatalariDummy.responseBodyOlusturMap();
        System.out.println("expectedDataMap = " + expectedDataMap);

        // 3. request gonder ve donen response'yi kaydet

        Response response = given()
                                  .when().spec(specDummyExample)
                                  .get("/{pp1}/{pp2}");

        // 4. Assertion

        // Assertion yapabilmemiz icin response'yi Map'e cevirmemiz gerekir(De-serialization)

        Map<String ,Object> responseMap = response.as(HashMap.class);
        System.out.println("responseMap = " + responseMap);

        assertEquals(TestDatalariDummy.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDatalariDummy.contentType,response.contentType());

        assertEquals(expectedDataMap.get("status"),responseMap.get("status"));
        assertEquals(expectedDataMap.get("message"),responseMap.get("message"));

        assertEquals(((Map)expectedDataMap.get("data")).get("id"),
                     ((Map)responseMap.get("data")).get("id"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_name"),
                     ((Map)responseMap.get("data")).get("employee_name"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_salary"),
                     ((Map)responseMap.get("data")).get("employee_salary"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_age"),
                     ((Map)responseMap.get("data")).get("employee_age"));

        assertEquals(((Map)expectedDataMap.get("data")).get("profile_image"),
                     ((Map)responseMap.get("data")).get("profile_image"));


    }


}
