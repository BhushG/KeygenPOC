package license;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

public class UpdateLicense {
    public static void main(String[] args) throws Exception {
        String licenseUpdateData = "{\n" +
                "\"data\": {\n" +
                    "\"type\":\"licenses\",\n" +
                    "\"attributes\": {\n" +
                        "\"expiry\": \"2020-12-12T00:00:00.000Z\"\n" +
                        "}\n" +
                    "}\n" +
                "}";

        JSONObject body = new JSONObject(licenseUpdateData);

        System.out.println(body);


        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";
        String license_id = "afceb3d8-825b-4437-9483-ebcab4490964";

        HttpResponse<JsonNode> res = Unirest.patch("https://api.keygen.sh/v1/accounts/"+account_id+"/licenses/"+license_id)
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
