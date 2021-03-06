package policies;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;

/**
 * To retrieve policy we need admin bearer or bearer token of product to which it belongs.
 */
public class RetrievePolicy {
    public static void main(String[] args) throws Exception{
        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";
        String policy_id = "8fe8bf88-abfa-4adf-93f1-e7ade3ebdbe6";

        HttpResponse<JsonNode> res = Unirest.get("https://api.keygen.sh/v1/accounts/"+account_id+"/policies/"+policy_id)
                .header("Authorization", admin_bearer_token)
                .header("Accept", "application/vnd.api+json")
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
