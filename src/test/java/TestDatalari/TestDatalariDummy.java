package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDatalariDummy {

    public static int basariliSorguStatusCode = 200;
    public static String contentType = "application/json";


    public static JSONObject JsonResponseBodyOlustur(int id, String employee_name, int employee_salary, int employee_age, String profile_image){

        JSONObject responseBody = new JSONObject();
        JSONObject dataBody = new JSONObject();

        dataBody.put("id",id);
        dataBody.put("employee_name",employee_name);
        dataBody.put("employee_salary",employee_salary);
        dataBody.put("employee_age",employee_age);
        dataBody.put("profile_image",profile_image);

        responseBody.put("status","success");
        responseBody.put("message","Successfully! Record has been fetched.");
        responseBody.put("data",dataBody);

        return responseBody;


    }

    /*

    {
                "status":"success",
                "data":{
                      "id":3,
                      "employee_name":"Ashton Cox",
                      "employee_salary":86000,
                      "employee_age":66,
                      "profile_image":"",
                      },
                "message":"Successfully! Record has been fetched."
      }

     */

    public static Map<String,Object> responseBodyOlusturMap(){

        Map<String,Object> responseBodyMap = new HashMap<>();
        Map<String,Object> dataBodyMap = new HashMap<>();

        dataBodyMap.put("id",3.0);
        dataBodyMap.put("employee_name","Ashton Cox");
        dataBodyMap.put("employee_salary",86000.0);
        dataBodyMap.put("employee_age",66.0);
        dataBodyMap.put("profile_image","");

        responseBodyMap.put("status","success");
        responseBodyMap.put("message","Successfully! Record has been fetched.");
        responseBodyMap.put("data",dataBodyMap);

        return responseBodyMap;

    }


}
