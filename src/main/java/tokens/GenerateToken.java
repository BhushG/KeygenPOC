package tokens;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;
import org.json.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This API is used to generate tokens for given user account. We need to pass user credentials.
 * There is no expiry for admin token.
 */
public class GenerateToken {
    public static void main(String[] args) throws Exception{

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";


        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+ account_id + "/tokens")
                .header("Accept", "application/vnd.api+json")
                .basicAuth("prafulrana@gmail.com", "Praful*001")
                .asJson();
        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());
    }
}
