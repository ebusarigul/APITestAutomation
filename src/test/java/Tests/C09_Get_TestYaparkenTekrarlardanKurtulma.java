package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test
    public void test01(){

        /*

         https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
         donen Response’un,
         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki
         "firstname“in, "Sally",
         ve "lastname“in, "Jackson",
         ve "totalprice“in, 1000 den küçük oldugunu,
         ve "depositpaid“in, false,
         ve "additionalneeds“in, bos oldugunu
         oldugunu test edin (slayt sayfa 101)

         */


        //1- Endpoint ve Request body hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //3- Request gönderip dönen response ı kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        /* ilk öğrendiğimiz yönteme göre böyle olması gerek fakat body ve matcherslar tekrar ediyor

        //4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mary"))
                .body("lastname", Matchers.equalTo("Brown"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(true))
                .body("additionalneeds", Matchers.notNullValue());
       */

        //4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mary"),
                        "lastname",equalTo("Brown"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(true),
                        "additionalneeds",notNullValue());




    }


}
