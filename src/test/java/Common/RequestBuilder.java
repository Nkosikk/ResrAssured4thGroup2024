package Common;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static Common.BasePaths.ReqRes_BaseURL;
import static Common.BasePaths.WeatherStation_BaseURL;
import static Common.ContentType.contentType;
import static Common.GenerateTestData.*;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static String userID;
    public static String stationID;

    public static String apiKey;

    static {
        try {
            apiKey = getApiKey();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response createUserResponse() {
        Response response = given().
                when().
                body(createEmployeeObject()).
                contentType(contentType).
                log().all().
                post(ReqRes_BaseURL + "/api/users").
                then().
                log().all().
                extract().response();
        userID = response.jsonPath().getString("id");


        return response;
    }


    public static Response updateEmployeeResponse() {
        return given().
                when().
                body(updateEmployeeObject()).
                contentType(contentType).
                log().all().
                put(ReqRes_BaseURL + "/api/users/" + userID).
                then().
                log().all().
                extract().response();
    }


    public static Response partialUpdateEmployeeResponse() {
        return given().
                when().
                body(partialUpdateEmployeeObject()).
                contentType(contentType).
                log().all().
                patch(ReqRes_BaseURL + "/api/users/" + userID).
                then().
                log().all().
                extract().response();
    }


    public static Response deleteEmployeeResponse() {
        return given().
                when().
                contentType(contentType).
                log().all().
                delete(ReqRes_BaseURL + "/api/users/" + userID).
                then().
                log().all().
                extract().response();
    }

    public static Response weatherStationResponse(String vExternalID, String vStationName, float vLatitude, float vLongitude, int vAltitude) throws IOException {
        Response response = given().
                queryParam("appid", apiKey).
                when().
                body(weatherStationObject(vExternalID, vStationName, vLatitude, vLongitude, vAltitude)).
                contentType(contentType).
                log().all().
                post(WeatherStation_BaseURL + "/data/3.0/stations").
                then().
                log().all().
                extract().response();
        stationID = response.jsonPath().getString("ID");

        return response;
    }


    public static Response updateweatherStationResponse( String vExternalID, String vStationName, float vLatitude, float vLongitude,int vAltitude) throws IOException {
        return given().
                queryParam("appid", apiKey).
                when().
                body(weatherStationObject(vExternalID, vStationName, vLatitude, vLongitude, vAltitude)).
                contentType(contentType).
                log().all().
                put(WeatherStation_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();


    }


    public static Response deleteWeatherStationResponse() {
        return given().
                queryParam("appid", apiKey).
                when().
                contentType(contentType).
                log().all().
                delete(WeatherStation_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();
    }

}
