package policies;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.util.HashMap;

public class CreatePolicy {
    public static void main(String[] args) throws Exception{
        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String product_id = "1dca1d79-3d0a-4146-99bf-5823007f807d";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";

        System.out.println("Creating Policy..");


        String jsonString = "{\n" +
                "\t\"data\": {\n" +
                "\t\t\"type\": \"policies\",\n" +
                "\t\t\"attributes\": {\n" +
                "\t\t\t\"name\": \"TrialPolicy\",\n" +
                "\t\t\t\"duration\": 172800,\n" +
                "\t\t\t\"strict\": true,\n" +
                "\t\t\t\"floating\": true,\n" +
                "\t\t\t\"maxMachines\": 2\n" +
                "\t\t},\n" +
                "\t\t\"relationships\": {\n" +
                "\t\t\t\"product\": {\n" +
                "\t\t\t\tdata: {\n" +
                "\t\t\t\t\t\"type\": \"products\",\n" +
                "\t\t\t\t\t\"id\": \"1dca1d79-3d0a-4146-99bf-5823007f807d\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        JSONObject body = new JSONObject(jsonString);

        System.out.println(body);

        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+account_id+"/policies")
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
