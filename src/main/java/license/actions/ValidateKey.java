package license.actions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

/**
 * Authorization is not required to validate key.
 * You will get License ID when you validate the license key.
 * Using that License ID you can check in.
 */
public class ValidateKey {
    public static void main(String[] args) throws Exception{
        String licenseKey= "{\n" +
                "\"meta\": {\n" +
                    "\"key\": \"c0e0b76bb3d54f6289c59bdeebe19fba-44cb6515c6217c2e627e5447c9e09b79-9a674be85ca2d9cc534ddc71c7866cd7-9bae76b113fd9ea527c9bbde730c11v2\"\n" +
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
