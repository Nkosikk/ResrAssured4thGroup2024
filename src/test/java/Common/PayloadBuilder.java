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
    public static JSONObject weatherStationObject(String vExternalID, String vStationName, float vLatitude, float vLongitude,int vAltitude) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id",vExternalID);
        jsonObject.put("name",vStationName);
        jsonObject.put("latitude",vLatitude);
        jsonObject.put("longitude",vLongitude);
        jsonObject.put("altitude",vAltitude);


        return jsonObject;
    }
//    public static JSONObject updateWeatherStationObject(String wStationName, float wLatitude, float wLongitude,int wAltitude) {
//
//        JSONObject jsonObject = new JSONObject();
//
//        jsonObject.put("name",wStationName);
//        jsonObject.put("latitude",wLatitude);
//        jsonObject.put("longitude",wLongitude);
//        jsonObject.put("altitude",wAltitude);
//
//
//
//        return jsonObject;
//    }

}
