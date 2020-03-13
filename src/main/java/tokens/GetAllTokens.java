package tokens;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;

/**
 * This API is used to retrieve details of existing token. We need to pass bearer token and token_id of which details we want.
 * Admin bearer token can be used to retrieve information of all the tokens.
 * User bearer token can be used to retrieve information of its token only (Token owner).
 */
public class GetAllTokens {
    public static void main(String[] args) throws Exception{

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_toekn = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";


        HttpResponse<JsonNode> res = Unirest.get("https://api.keygen.sh/v1/accounts/"+ account_id +"/tokens")
                .header("Authorization", admin_bearer_toekn)
                .header("Accept", "application/vnd.api+json")
                .queryString("limit", 5)
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
