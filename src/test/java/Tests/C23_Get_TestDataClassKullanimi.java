package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
            response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
            ediniz (slayt sayfa 141) (video 23)
            Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }
     */


    @Test
    public void test01() {


        // 1- endpoint ve request body oluştur

        specJsonPlaceholder.pathParams("pp1","posts","pp2","22");

        // 2- expected data oluştur

        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur22();

        // 3- request gönder ve dönen response'i kaydet

        Response response = given()
                                   .when().spec(specJsonPlaceholder)
                                   .get("/{pp1}/{pp2}");


        // 4- assertion

        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());

        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));



    }


}
