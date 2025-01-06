package Tests;

import TestDatalari.TestDatalariDummy;
import TestDatalari.TestDatalariHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {

    /*

      https://restful-booker.herokuapp.com/booking endpointine
      asagidaki body'e sahip bir POST request gonderdigimizde donen response'nin id haric
      asagidaki gibi oldugunu test edin (slayt sayfa 163) (video 29)

      Request Body

      {
         "firstname":"Ahmet",
         "lastname":"Bulut",
         "totalprice":500,
         "depositpaid":false,
         "bookingdates":{
            "checkin":"2021-06-01",
            "checkout":"2021-06-10",
          },
         "additionalneeds":"wi-fi"

       Response Body//expected data

       {
       "bookingid":24,
       "booking"{
           "firstname":"Ahmet",
           "lastname":"Bulut",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10",
          },
           "additionalneeds":"wi-fi"


*/

    @Test
    public void test01(){


        // 1.endpoint ve request body olustur

        specHerokuapp.pathParam("pp1","booking");
        Map <String,Object> requestBodyMap = TestDatalariHerokuapp.requestBodyOlusturMap();

        // 2. expected data olustur(soruda varsa)

        Map <String,Object> expectedDataMap = TestDatalariHerokuapp.responseBodyOlusturMap();

        // 3. request gonder ve donen response'yi kaydet

        Response response = given().contentType(ContentType.JSON)
                                   .when().spec(specHerokuapp).body(requestBodyMap)
                                   .post("/{pp1}");


        // 4. Assertion

        // Assertion yapabilmemiz icin response'yi Map'e cevirmemiz gerekir(De-serialization)
        Map<String ,Object> responseMap = response.as(HashMap.class);


        assertEquals(((Map)expectedDataMap.get("booking")).get("firstname"),
                     ((Map)responseMap.get("booking")).get("firstname"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("lastname"),
                     ((Map)responseMap.get("booking")).get("lastname"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("totalprice"),
                     ((Map)responseMap.get("booking")).get("totalprice"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("depositpaid"),
                     ((Map)responseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("additionalneeds"),
                     ((Map)responseMap.get("booking")).get("additionalneeds"));


        assertEquals(((Map)((Map)expectedDataMap.get("booking")).get("bookingdates")).get("checkin"),
                     ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkin"));

        assertEquals(((Map)((Map)expectedDataMap.get("booking")).get("bookingdates")).get("checkout"),
                     ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkout"));


    }




}
