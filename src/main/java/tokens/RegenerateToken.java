package tokens;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class RegenerateToken {
    public static void main(String[] args) throws Exception {
        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String token_id = "07797773-63bc-4dd3-87d5-969a47437317";
        String admin_bearer_toekn = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";


        HttpResponse<JsonNode> res = Unirest.put("https://api.keygen.sh/v1/accounts/"+ account_id +"/tokens/" + token_id)
                .header("Authorization", admin_bearer_toekn)
                .header("Accept", "application/vnd.api+json")
                .asJson();

        System.out.println(res.getStatus());
        System.out.println(res.getStatusText());
        System.out.println(res.getBody().toString());
    }
}
