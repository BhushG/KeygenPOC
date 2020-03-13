package products;

import com.mashape.unirest.http.exceptions.*;
import com.mashape.unirest.http.*;
import org.json.*;

import java.util.HashMap;

/**
 * Creates new product.
 * To create new product we need admin bearer token. i.e. Admin privileges
 */
public class CreateProduct {
    public static void main(String[] args) throws Exception{
        System.out.println("Creating Product..");

        String [] platforms = {"GCP","AWS"};




        HashMap productMeta = new HashMap<String, String>();
        productMeta.put("name","Streamflux");
        productMeta.put("url","https://zerogons.com/");
        productMeta.put("platforms",platforms);


        HashMap userdata = new HashMap();
        userdata.put("type", "products");
        userdata.put("attributes", productMeta);

        HashMap mapBody = new HashMap();
        mapBody.put("data", userdata);

        JSONObject body = new JSONObject(mapBody);

        System.out.println(body);

        String account_id = "56e9da3d-2f55-4eda-90a1-795359b3ce74";
        String admin_bearer_token = "Bearer admi-79c112ca112a6f199d4268fed1c56c6be64d760f8045019207866dacc9c865245601b1054dcad5b125afb690c443f5ec9a229a4129160b70810ea6cdd0ec59v2";


        HttpResponse<JsonNode> res = Unirest.post("https://api.keygen.sh/v1/accounts/"+ account_id +"/products")
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
