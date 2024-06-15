package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {

    /*
    //2- https://restful-booker.herokuapp.com/booking
    //endpointine assagıdaki body’ye sahip bir POST request
    //gonderdigimizde donen response’un status code’unun
    //200 oldugunu ve “firstname” degerinin “Ahmet”
    //oldugunu test edin  (slayt sayfa 138)

        /*
        {
                "firstname" : "Ahmet",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                },
                "additionalneeds" : "wi-fi"
         }

         */

    @Test
    public void test02(){

        // 1- endpoint ve request body oluştur

        specHerokuapp.pathParam("pp1","booking");

        JSONObject bookingDateJson = new JSONObject();
        bookingDateJson.put("checkin","2021-06-01");
        bookingDateJson.put("checkout","2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("additionalneeds","wi-fi");
        requestBody.put("bookingdates",bookingDateJson);

        // 2- expected data oluştur

        // 3- request gönder ve dönen response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                .when().spec(specHerokuapp).body(requestBody.toString())
                .post("/{pp1}");

        response.prettyPrint();

        // 4- assertion

        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ahmet"));




    }


}
