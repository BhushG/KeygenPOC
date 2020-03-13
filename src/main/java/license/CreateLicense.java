package license;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

/**
 * We can use either product bearer token or admin bearer token to create licenses.
 */
public class CreateLicense {
    public static void main(String[] args) throws Exception{
        String jsonString = "{\n" +
                "\"data\": {\n" +
                    "\"type\":\"licenses\",\n" +
                    "\"relationships\": {\n" +
                        "\"policy\": {\n" +
                            "\"data\":{\n" +
                                "\"type\": \"policies\",\n" +
                                "\"id\": \"8fe8bf88-abfa-4adf-93f1-e7ade3ebdbe6\"\n" +
                            "}\n" +
                        "},\n" +
                        "\"user\": {\n" +
                            "\"data\":{\n" +
                                "\"type\":\"users\",\n" +
                                "\"id\":\"e2debcd1-8662-4bf5-b3c0-1bc3198917aa\"\n" +
                            "}\n" +
                        "}\n" +
                    "}\n" +
                    "}\n" +
                "}";

        JSONObject body = new JSONObject(jsonString);

        System.out.println(body);


        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";


        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+account_id+"/licenses")
                .header("Authorization", admin_bearer_token)
                .header("Content-Type", "application/vnd.api+json")
                .header("Accept", "application/vnd.api+json")
                .body(body)
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
