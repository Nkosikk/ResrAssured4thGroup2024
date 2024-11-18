package Common;

import org.json.simple.JSONObject;


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
        jsonObject.put("Job", "Tester");
        jsonObject.put("34", " aberdeen kensington");

        return jsonObject;
    }

    public static JSONObject update1EmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Mthembu");
        jsonObject.put("Job", "Tester");
        jsonObject.put("34", " aberdeen kensington");

        return jsonObject;


    }

    public static JSONObject deleteEmployeeObject(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Mthembu");
        jsonObject.put("Job", "Tester");
        jsonObject.put("34", " aberdeen kensington");

        return jsonObject;

    }


}
