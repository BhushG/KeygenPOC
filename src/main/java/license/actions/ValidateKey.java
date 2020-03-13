package license.actions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

/**
 * Authorization is not required to validate key
 */
public class ValidateKey {
    public static void main(String[] args) throws Exception{
        String licenseKey= "{\n" +
                "\"meta\": {\n" +
                    "\"key\": \"afceb3d8825b44379483ebcab4490964-4c543e51532f7a34b85f68b58e946ef3-8be9bca27541273d445d133e7b463508-93594f1c497808389af47cd7c47c5dv2\"\n" +
                    "}\n" +
                "}";

        JSONObject body = new JSONObject(licenseKey);

        System.out.println(body);

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";

        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+account_id+"/licenses/actions/validate-key")
                .header("Content-Type", "application/vnd.api+json")
                .header("Accept", "application/vnd.api+json")
                .body(body)
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
