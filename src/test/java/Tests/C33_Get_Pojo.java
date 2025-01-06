package Tests;

import Pojos.*;
import baseUrl.BaseUrlDummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C33_Get_Pojo extends BaseUrlDummy {


    /*
           http:dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
           gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.
           (slayt sayfa 172) (video 32)

           Response Body//expected data
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

    @Test
    public void test01(){


        // 1.endpoint ve request body olustur

        specDummyExample.pathParams("pp1","employee","pp2",3);


        // 2.soruda varsa expected data olustur

        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3,"Ashton Cox",86000,66,"");
        PojoDummyExampleResponseBody expectedResponseBody = new PojoDummyExampleResponseBody("success",dataPojo,
                                                        "Successfully! Record has been fetched.") ;


        // 3.Request gonder donen response'yi kaydet

        Response response = given()
                                   .when().spec(specDummyExample)
                                   .get("/{pp1}/{pp2}");


        // 4. Assertion
        // expected data (pojo)<-----> response (pojo) olmali
        // hazir ceviriciler attribute ismini degistirdiginden response'yi pojo'ya
        // convert edemedik, bu durumda teste devam edebilmek icin response'yi
        // Jsonpath'e cevirebiliriz.

        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(expectedResponseBody.getStatus(),responseJsonPath.get("status"));
        assertEquals(expectedResponseBody.getMessage(),responseJsonPath.get("message"));

        assertEquals(expectedResponseBody.getData().getId()
                                                   ,responseJsonPath.get("data.id"));
        assertEquals(expectedResponseBody.getData().getEmployeeName()
                                                   ,responseJsonPath.get("data.employee_name"));
        assertEquals(expectedResponseBody.getData().getEmployeeSalary()
                                                   ,responseJsonPath.get("data.employee_salary"));
        assertEquals(expectedResponseBody.getData().getEmployeeAge()
                                                   ,responseJsonPath.get("data.employee_age"));
        assertEquals(expectedResponseBody.getData().getProfileImage()
                                                   ,responseJsonPath.get("data.profile_image"));



    }

}
