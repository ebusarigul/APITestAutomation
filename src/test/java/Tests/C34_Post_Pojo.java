package Tests;

import Pojos.PojoDummyExampleData;
import Pojos.PojoDummyExampleResponseBody;
import Pojos.PojosHavaDurumu.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class C34_Post_Pojo {


    /*
       "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2fO"
        url'ine bir post request gonderdigimizde donen response'un asagidaki body'e sahip oldugunu
        test edin  (slayt sayfa 174) (video 33)
    */

    /*
                       {
                         "coord": {
                           "lon": -0.1257,
                           "lat": 51.5085
                         },
                         "weather": [
                           {
                             "id": 802,
                             "main": "Clouds",
                             "description": "scattered clouds",
                             "icon": "03d"
                           }
                         ],
                         "base": "stations",
                         "main": {
                           "temp": 294.2,
                           "feels_like": 293.88,
                           "temp_min": 293.01,
                           "temp_max": 295.51,
                           "pressure": 1015,
                           "humidity": 58
                         },
                         "visibility": 10000,
                         "wind": {
                           "speed": 3.09,
                           "deg": 10
                         },
                         "clouds": {
                           "all": 40
                         },
                         "dt": 1718715366,
                         "sys": {
                           "type": 2,
                           "id": 2091269,
                           "country": "GB",
                           "sunrise": 1718682164,
                           "sunset": 1718742042
                         },
                         "timezone": 3600,
                         "id": 2643743,
                         "name": "London",
                         "cod": 200
                      }
*/

    @Test
    public void test01(){


        // 1.endpoint ve request body olustur

        String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f63615dfea6b2b48089ccd9aa0b5b583";

        // 2.soruda varsa expected data olustur

        Coord coordPojo = new Coord(-0.1257f,51.5085f);
        List<Weather> weatherList = new ArrayList<>();
        Weather weatherPojo = new Weather(802,"Clouds","scattered clouds","03d");
        weatherList.add(weatherPojo);
        Main mainPojo = new Main(294.2f,293.88f,293.01f,295.51f,1015,58);
        Wind windPojo = new Wind(3.09f,10);
        Clouds cloudsPojo = new Clouds(40);
        Sys sysPojo = new Sys(2,2091269,"GB",1718682164,1718742042);
        PojoHavaDurumu expectedResponseBody = new PojoHavaDurumu(coordPojo,weatherList,"stations",mainPojo,10000,windPojo,
                                                                 cloudsPojo,1718715366,sysPojo,3600,2643743,"London",200);


        // 3.Request gonder donen response'yi kaydet

        Response response = given()
                                   .when()
                                   .post(url);


        // 4. Assertion

        // expectedResponseBody Pojo<---->response/responseJP
        PojoHavaDurumu responsePojo = response.as(PojoHavaDurumu.class);

        // response'yi Pojo'ya cevirdigimizde tum bilgileri getirirse responsePojo'yu
        // assertion'da kullanabiliriz.Eger null deger donerse, response'yi JsonPath yapip
        // assertion'da kullanabiliriz.(burada null gelenler oldu, bu nedenle JsopnPath
        // olusturuldu ve degismeyen degerlerden birkaci asert edildi.)

        System.out.println(responsePojo);
        //bu ciktida null degerler oldugu goruluyor, bu nedenle JsonPath kullanildi

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedResponseBody.getCoord().getLon()
                                                           ,responseJsonPath.get("coord.lon"));
        Assert.assertEquals(expectedResponseBody.getCoord().getLat()
                                                           ,responseJsonPath.get("coord.lat"));

        Assert.assertEquals(expectedResponseBody.getBase(),responseJsonPath.get("base"));

        Assert.assertEquals(expectedResponseBody.getSys().getCountry()
                                                          ,responseJsonPath.get("sys.country"));

        Assert.assertEquals(expectedResponseBody.getName()
                                                          ,responseJsonPath.get("name"));


    }


}
