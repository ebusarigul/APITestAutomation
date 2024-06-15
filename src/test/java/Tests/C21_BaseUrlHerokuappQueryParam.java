package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    /*
        1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
           yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek bir GET
           request gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Eric”
           ismine sahip en az bir booking oldugunu test edin (slayt sayfa 139)
    */


    @Test
    public void test01() {


        // 1- endpoint ve request body oluştur

        specHerokuapp.pathParam("pp1", "booking")
                     .queryParam("firstname", "Eric");

        // 2- expected data oluştur

        // 3- request gönder ve dönen response'i kaydet

        //query parametresini ilk adımda eklediğimiz için get in içine eklememize gerek kalmadı
        Response response = given()
                                   .when().spec(specHerokuapp)
                                   .get("/{pp1}");


        // 4- assertion

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.notNullValue());


    }

}
