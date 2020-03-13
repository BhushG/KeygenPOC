package users;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;
import org.json.*;

import java.util.HashMap;
import java.util.Map;

public class CreatingUser {
    public static void main(String[] args) throws Exception{
        System.out.println("Creating User..");

        HashMap userMeta = new HashMap<String, String>();
        userMeta.put("firstName","Praful");
        userMeta.put("lastName","Rana");
        userMeta.put("email","prafulrana@gmail.com");
        userMeta.put("password","Praful*001");


        HashMap userdata = new HashMap();
        userdata.put("type", "users");
        userdata.put("attributes", userMeta);

        HashMap mapBody = new HashMap();
        mapBody.put("data", userdata);

        JSONObject body = new JSONObject(mapBody);

        System.out.println(body);

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";

        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+account_id+"/users")
                .header("Content-Type", "application/vnd.api+json")
                .header("Accept", "application/vnd.api+json")
                .body(body)
                .asJson();

        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());
    }
}
