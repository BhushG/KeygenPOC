package products;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;

/**
 * Product tokens should not be included in any client-facing code, as they offer full access to all of the product's resources
 */
public class ProductInfoFromProductToken {
    public static void main(String[] args) throws Exception{
        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String product_bearer_token = "Bearer prod-399b1c94fa0980ac8daa1b67e807e04d8906d8aaf257b8e56137824c2c0195950a2674e1a1a309f1cc5bab4be38a37bd1ddc2543df0c13386c60fb33ab3fe6v2";
        String product_id = "1dca1d79-3d0a-4146-99bf-5823007f807d";

        HttpResponse<JsonNode> res = Unirest.get("https://api.keygen.sh/v1/accounts/"+ account_id + "/products/" + product_id )
                .header("Authorization", product_bearer_token)
                .header("Accept", "application/vnd.api+json")
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());

    }
}
