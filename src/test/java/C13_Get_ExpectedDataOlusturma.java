import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test01(){

        /*

        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz (slayt sayfa 119)

        {
          "userId": 3,
          "id": 22,
          "title": "dolor sint quo a velit explicabo quia nam",
          "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
                   um mollitia molestiae aut atque rem suscipitnam impedit esse"
        }

         */

        //1- Endpoint ve Request body hazırlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        //2- Expected data olustur
        JSONObject expectedDataJson = new JSONObject();
        expectedDataJson.put("userId", 3);
        expectedDataJson.put("id", 22);
        expectedDataJson.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedDataJson.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- Request gönderip dönen response ı kaydetme
        Response response = given().when().get(url);

        //4- Assertion

        /*  Bugüne kadar yaptıgımız yöntemlede testlerimizi yapabiliriz. Ancak Frameworkü gelistirmeye devam ediyoruz
        response.then().assertThat()
                .body("userId", equalTo(3))
                .body("id", equalTo(22))
                .body("title", equalTo("dolor sint quo a velit explicabo quia nam"));
        */

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(responseJsonPath.get("userId"),expectedDataJson.get("userId"));
        Assert.assertEquals(responseJsonPath.get("id"),expectedDataJson.get("id"));
        Assert.assertEquals(responseJsonPath.get("title"),expectedDataJson.get("title"));
        Assert.assertEquals(responseJsonPath.get("body"),expectedDataJson.get("body"));


    }


}
