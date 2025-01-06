package Tests;

import Pojos.PojoJsonPlaceholder;
import TestDatalari.TestDataJsonPlaceholder;
import TestDatalari.TestDatalariHerokuapp;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {


    /*  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip
        bir PUT request yolladigimizda donen response'nin status kodunun 200,
        content type'inin "application.json;charset=utf-8",
        connection header degerinin "keep-alive"
        ve response body'sinin asagida verilen ile ayni oldugunu test ediniz.
        (slayt sayfa 167) (video 30)

         Request Body
         {
         "title":"Ahmet",
         "body":"Merhaba",
         "userId":10,
         "id":70
         }

         Expected Data---Response Body
         {
         "title":"Ahmet",
         "body":"Merhaba",
         "userId":10,
         "id":70
         }
     */


    @Test
    public void test01(){


        // 1.endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 2. expected data olustur(soruda varsa)

        PojoJsonPlaceholder expectedDataPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);


        // 3. request gonder ve donen response'yi kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().spec(specJsonPlaceholder).body(requestBodyPojo)
                                   .put("/{pp1}/{pp2}");

        // 4. Assertion

        // expected data (pojo)<-----> response (pojo) olmali

        PojoJsonPlaceholder responsePojo = response.as(PojoJsonPlaceholder.class);

        System.out.println(expectedDataPojo);
        System.out.println(responsePojo);

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());


        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());


    }


}
