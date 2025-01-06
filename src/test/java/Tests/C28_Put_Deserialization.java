package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_Deserialization extends BaseUrlJsonPlaceholder {

    /*
               https://jsonplaceholder.typicode.com/posts/70 url/sine asagidaki body'e sahip bir PUT
               request yolladigimizda donen response'in response body'sinin asagida verilen ile ayni
               oldugunu test ediniz (slayt sayfa 159) (video 27)

               Request Body
               {
               "title":"Ahmet",
               "body":"Merhaba",
               "userId":10,
               "id":70
               {

               Expected Data (Response body)
               {
               "title":"Ahmet",
               "body":"Merhaba",
               "userId":10,
               "id":70
               {

     */


    @Test
    public void test01(){


        // 1.endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        // request body'i map kullanarak olusturacagiz

        Map<String,Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap();
        System.out.println("requestBodyMap = " + requestBodyMap);

        // 2. expected data olustur(soruda varsa)

        Map<String,Object> expectedDataMap = TestDataJsonPlaceholder.bodyOlusturMap();
        System.out.println("expectedDataMap = " + expectedDataMap);

        // 3. request gonder ve donen response'yi kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().spec(specJsonPlaceholder).body(requestBodyMap)
                                   .put("/{pp1}/{pp2}");


        // 4. Assertion

        // Assertion yapabilmemiz icin response'yi Map'e cevirmemiz gerekir(De-serialization)

        Map<String ,Object> responseMap = response.as(HashMap.class);
        System.out.println("responseMap = " + responseMap);

        assertEquals(expectedDataMap.get("title"),responseMap.get("title"));
        assertEquals(expectedDataMap.get("body"),responseMap.get("body"));
        assertEquals(expectedDataMap.get("userId"),responseMap.get("userId"));
        assertEquals(expectedDataMap.get("id"),responseMap.get("id"));


    }


}
