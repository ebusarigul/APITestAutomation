package Tests;

import Pojos.PojoHerokuappBookingDates;
import Pojos.PojoHerokuappRequestBody;
import Pojos.PojoHerokuappResponseBody;
import Pojos.PojoJsonPlaceholder;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {


    /*
         https://restful-booker.herokuapp.com/booking url'ine asagidaki body'e sahip bir POST
         request gonderdigimizde donen response'nin id haric asagidaki gibi oldugunu test edin
         (slayt sayfa 169) (video 31)

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

          Response Body // expected data
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

    @Test
    public void test01(){

        // 1.endpoint ve request body olustur

        specHerokuapp.pathParam("pp1", "booking");

        PojoHerokuappBookingDates  bookingdatesPojo =
                new PojoHerokuappBookingDates("2021-06-01", "2021-06-10");

        PojoHerokuappRequestBody requestBodyPojo =
                new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");


       // 2.soruda varsa expected data olustur

        PojoHerokuappResponseBody expectedResponseBodyPojo = new PojoHerokuappResponseBody(24,requestBodyPojo);


       // 3.Request gonder donen response'yi kaydet
        Response response = given().contentType(ContentType.JSON).spec(specHerokuapp)
                                   .when().body(requestBodyPojo)
                                   .post("/{pp1}");

        response.prettyPrint();

        // 4. Assertion
        // expected data (pojo)<-----> response (pojo) olmali
        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);
        System.out.println(expectedResponseBodyPojo);
        System.out.println(responsePojo);


        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),
                responsePojo.getBooking().getFirstname());

        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),
                responsePojo.getBooking().getLastname());

        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),
                responsePojo.getBooking().getTotalprice());

        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),
                responsePojo.getBooking().getAdditionalneeds());

        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),
                responsePojo.getBooking().isDepositpaid());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingDates().getCheckin(),
                responsePojo.getBooking().getBookingDates().getCheckin());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingDates().getCheckout(),
                responsePojo.getBooking().getBookingDates().getCheckout());



    }


}
