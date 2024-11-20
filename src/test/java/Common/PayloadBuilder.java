package Common;

import org.json.simple.JSONObject;

import static Common.GenerateTestData.*;



public class PayloadBuilder {

    public static JSONObject createEmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",firstName);
        jsonObject.put("job", jobTime);

        return jsonObject;
    }

    public static JSONObject updateEmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Cele");
        jsonObject.put("job", "Tester");
        jsonObject.put("address","34 aberdeen kensington");

        return jsonObject;
    }

    public static JSONObject partialUpdateEmployeeObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Cele");
        jsonObject.put("job", "Team Lead");
        jsonObject.put("address","34 aberdeen kensington");

        return jsonObject;
    }
    public static JSONObject createWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id",externalID);
        jsonObject.put("name",stationName);
        jsonObject.put("latitude",latitude);
        jsonObject.put("longitude",longitude);
        jsonObject.put("altitude",altitude);


        return jsonObject;
    }
}
