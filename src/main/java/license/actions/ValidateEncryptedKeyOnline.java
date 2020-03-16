package license.actions;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

public class ValidateEncryptedKeyOnline {
    public static void main(String[] args) throws Exception{
        String licenseKey= "{\n" +
                "\t\"meta\": {\n" +
                "\t\t\"key\":\"eyJuYW1lIjoicHJhZnVsIHJhbmEiLCAidmFsaWQiOiAidG9tb3Jyb3cifQ==.m3ZP1_NwXG0Z8lxdIYa2NVy6lwb6sR2pQWGwqh6Gn_NGzoHJfqCCeZ4b7cMgr5Ubi_1munyZKddk6q7cs97IdvSwOfTvTFSzpmCmzpeeY_5s68KcKaQfLIlVpU7u0-N9JdRTNzeDerOXAwniHpX9iB6YzoFJm4a9I0mhIcT2KcTuKWtFFlzuzhb61lIWh3kH3oCMFUAt4d2gkG5tpBPen8hfAVUZXQxVCKyRfzPxmrrCYojfRDEIS1JTbIxiCnUS4pBbPREfbGYv5mgA2yzDtUU14k5w7KGNTEjIEbLNkGGQ4XxWtaUYSz0bRigU1h5erXw0ElGQIEeTlHmRJWvWFQ==\"\n" +
                "\t}\n" +
                "}";

        JSONObject body = new JSONObject(licenseKey);

        System.out.println(body);

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";

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
