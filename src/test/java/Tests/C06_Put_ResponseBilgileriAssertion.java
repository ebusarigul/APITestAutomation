package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {

    @Test
    public void test01() {

     /*

     https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
     PUT request gonderdigimizde
     {
     "title": "Ahmet",
     "body": "Merhaba",
     "userId": 10,
     "id": 70
     }
     donen Response’un,
     status code’unun 200,
     ve content type’inin application/json; charset=utf-8,
     ve Server isimli Header’in degerinin cloudflare,
     ve status Line’in HTTP/1.1 200 OK

      */


        //1- Request body ve endpoint hazırlama

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Ahmet");
        requestBody.put("body", "Merhaba");
        requestBody.put("userId", 10);
        requestBody.put("id", 70);

        //3- Request gönderip dönen response ı kaydetme

        Response response = given()
                                  .contentType(ContentType.JSON)
                                  .when()
                                  .body(requestBody.toString())
                                  .put(url);

        //4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }

}
