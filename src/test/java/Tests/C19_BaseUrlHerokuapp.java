package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    // 1- https://restful-booker.herokuapp.com/booking endpointine bir GET
    // request gonderdigimizde donen response’un status code’unun 200
    // oldugunu ve Response’ta 12 booking oldugunu test edin (slayt sayfa 138)


    @Test
    public void test01(){

        // 1- endpoint ve request body oluştur

        specHerokuapp.pathParam("pp1","booking");

        // 2- expected data oluştur

        // 3- request gönder ve dönen response'i kaydet
        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4- assertion

        JsonPath responseJsonPath= response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size());

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(1200));


    }



}
