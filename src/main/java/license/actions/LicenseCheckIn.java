package license.actions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class LicenseCheckIn {
    public static void main(String[] args) throws Exception{
        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";
        String license_id = "c0e0b76b-b3d5-4f62-89c5-9bdeebe19fba";

        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+account_id+"/licenses/"+ license_id +"/actions/check-in")
                .header("Authorization", admin_bearer_token)
                .header("Accept", "application/vnd.api+json")
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
