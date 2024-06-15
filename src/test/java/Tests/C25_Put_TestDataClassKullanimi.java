package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {


    /*

        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
        yolladigimizda donen response’in
        status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
        degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz (slayt sayfa 148) (video 24)

        Request Body
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }

        Expected Data :
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }

     */

    @Test
    public void test01(){

        // 1- endpoint ve request body oluştur

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 2- expected data oluştur

        JSONObject expectedData = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 3- request gönder ve dönen response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().spec(specJsonPlaceholder).body(requestBody.toString())
                                   .put("/{pp1}/{pp2}");

        // 4- assertion

        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.connectionHeader,response.header("Connection"));

        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));


    }


}
