package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOlusturma {

    @Test
    public void test01(){

        /*
          Asagidaki JSON Objesini olusturup konsolda
          yazdirin.

          {
          "title":"Ahmet",
          "body":"Merhaba",
          "userId":1
          }
        */


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId","1");

        System.out.println(jsonObject);





    }


}
