package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import TestDatalari.TestDatalariHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {


    /*
        https://restful-booker.herokuapp.com/booking url'ine asagidaki body'e sahip bir POST
        request gonderdigimizde donen response'nin id haric asagidaki gibi oldugunu test edin
        (slayt sayfa 152) (video 26)

        Request Body
        {
        "firstname":"Ahmet"
        "lastname":"Bulut"
        "totalprice":500,
        "depositpaid":false,
        "bookingdates":{
            "checkin":"2023-01-10",
            "checkout":"2023-01-20"
            },
         "additionalneeds":"wi-fi"
         }


         Response Body
         {
         "bookingid":24
         "booking"{
             "firstname":"Ahmet",
             "lastname": "Bulut",
             "totalprice":500,
             "depositpaid":false,
             "bookingdates":{
                  "checkin":2021-06-01
                  "checkout":2021-06-10
                  },
             "additionalneeds'in "wi-fi"
          }
          }
 */

    @Test
    public void test01(){

        // 1- endpoint ve request body oluştur

        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody = TestDatalariHerokuapp.jsonRequestBodyOlustur("Ahmet","Bulut",
                500,false,"2023-01-10","2023-01-20","wi-fi");


        // 2- expected data oluştur

        JSONObject expectedData = TestDatalariHerokuapp.jsonResponseBodyOlustur(24, requestBody);

        // 3- request gönder ve dönen response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().spec(specHerokuapp).body(requestBody.toString())
                                   .post("/{pp1}");


        // 4- assertion


        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").getString("firstname"), responseJsonPath.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname"), responseJsonPath.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"), responseJsonPath.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"), responseJsonPath.getBoolean("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin")
                                                              , responseJsonPath.getString("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout")
                                                              , responseJsonPath.getString("booking.bookingdates.checkout"));

        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"), responseJsonPath.getString("booking.additionalneeds"));


    }


}
