package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    /*

  {
    "firstName": "John",
    "lastName": "Doe",
    "adress": {
      "streetAddress": "naist street",
      "city": "Nara",
      "postalCode": "630-0192"
    },
    "age": 26,
    "phoneNumbers": [
      {
        "number": "0123-4567-8888",
        "type": "iPhone"
      },
      {
        "number": "0123-4567-8910",
        "type": "home"
      }
    ]
  }

     */

    @Test
    public void test01() {

        //slayt sayfa 108

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject addressJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObject = new JSONObject();


        addressJsonObj.put("streetAddress", "naist street");
        addressJsonObj.put("city", "Nara");
        addressJsonObj.put("postalCode", "630-0192");

        cepTelJsonObj.put("type", "iPhone");
        cepTelJsonObj.put("number", "0123-4567-8888");

        evTelJsonObject.put("type", "home");
        evTelJsonObject.put("number", "0123-4567-8910");


        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObject);

        kisiBilgileriJsonObj.put("firstName", "John");
        kisiBilgileriJsonObj.put("lastName", "Doe");
        kisiBilgileriJsonObj.put("age", 26);
        kisiBilgileriJsonObj.put("address", addressJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);


        System.out.println("firstname = " + kisiBilgileriJsonObj.get("firstName"));


        System.out.println("address.streetAddress = " + kisiBilgileriJsonObj.getJSONObject("address")
                .get("streetAddress"));

        System.out.println("address.city = " + kisiBilgileriJsonObj.getJSONObject("address")
                .get("city"));

        System.out.println("cep tel no = " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));


    }


}
