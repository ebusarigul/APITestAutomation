package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDatalariHerokuapp {

    /*
    Request Body
        {
        "firstname":"Ahmet"
        "lastname":"Bulut"
        "totalprice":500,
        "depositpaid":false,
        "bookingdates":{
            "checkin":"2023-01-10",
            "checkout":"2023-01-20"
            },
         "additionalneeds":"wi-fi"
         }
     */


    public static JSONObject jsonRequestBodyOlustur(String firstname, String lastname, int totalprice, boolean depositpaid
    , String checkin, String checkout, String additionalneeds){

        JSONObject bookingDatesJsonObjesi = new JSONObject();
        JSONObject requestBody = new JSONObject();

        bookingDatesJsonObjesi.put("checkin",checkin);
        bookingDatesJsonObjesi.put("checkout",checkout);

        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("totalprice",totalprice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookingdates",bookingDatesJsonObjesi);
        requestBody.put("additionalneeds",additionalneeds);

        return requestBody;



    }

    /*
    Response Body
         {
         "bookingid":24
         "booking"{
             "firstname":"Ahmet",
             "lastname": "Bulut",
             "totalprice":500,
             "depositpaid":false,
             "bookingdates":{
                  "checkin":2021-06-01
                  "checkout":2021-06-10
                  },
             "additionalneeds'in "wi-fi"
          }
         }
     */

    public static JSONObject jsonResponseBodyOlustur(int bookingid, JSONObject booking){

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid",bookingid);
        expectedData.put("booking", booking);

        return expectedData;


    }

    /*
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

    public static Map<String,Object> requestBodyOlusturMap(){

        Map<String,Object> requestBodyMap = new HashMap<>();

        requestBodyMap.put("firstname","Ahmet");
        requestBodyMap.put("lastname","Bulut");
        requestBodyMap.put("totalprice",500.0);
        requestBodyMap.put("depositpaid",false);
        requestBodyMap.put("additionalneeds","wi-fi");
        requestBodyMap.put("bookingdates",bookingDatesOlusturMap());

        return requestBodyMap;

    }

    public static Map<String,String> bookingDatesOlusturMap(){

        Map<String,String> bookingDatesBodyMap = new HashMap<>();

        bookingDatesBodyMap.put("checkin","2021-06-01");
        bookingDatesBodyMap.put("checkout","2021-06-10");

        return bookingDatesBodyMap;


    }

    /*
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

    public static Map<String,Object> responseBodyOlusturMap(){

        Map<String,Object> responseBodyMap = new HashMap<>();

        responseBodyMap.put("bookingid",24);
        responseBodyMap.put("booking",requestBodyOlusturMap());

        return responseBodyMap;

    }



}
