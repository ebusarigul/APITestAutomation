package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {

    @Test
    public void get01(){

        //1- Request body ve endpoint hazırlama
        //2- expected data hazırlama
        //3- Request gönderip dönen response ı kaydetme
        //4- Assertion


        //https://restful-booker.herokuapp.com/booking/10  url ine bir get request gönderdigimzde dönen
        //response u yazdırın.(slayt sayfa 85)

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        response.prettyPrint();


    }

}
