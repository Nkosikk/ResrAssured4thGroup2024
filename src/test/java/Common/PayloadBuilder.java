package Common;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PayloadBuilder {

    public static JSONObject createEmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Cele");
        jsonObject.put("job", "Tester");

        return jsonObject;
    }

    public static JSONObject updateEmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Cele");
        jsonObject.put("job", "Tester");
        jsonObject.put("address","34 aberdeen kensington");

        return jsonObject;
    }
}
