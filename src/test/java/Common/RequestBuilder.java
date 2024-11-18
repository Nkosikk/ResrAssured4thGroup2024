package Common;

import io.restassured.response.Response;

import static Common.BasePaths.ReqRes_BaseURL;
import static Common.ContentType.contentType;
import static Common.PayloadBuilder.*;
import static Common.PayloadBuilder.deleteEmployeeObject;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static String userID;

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

    public static Response updateUserResponse() {
        Response response = given().
                when().
                body(updateEmployeeObject()).
                contentType(contentType).
                log().all().
                post(ReqRes_BaseURL + "/api/users" + "/" + userID).
                then().
                log().all().
                extract().response();
        userID = response.jsonPath().getString("id");

        return response;

    }

    public static Response updateUser1Response() {
        Response response = given().
                when().
                body(update1EmployeeObject()).
                contentType(contentType).
                log().all().
                patch(ReqRes_BaseURL + "/api/users" + "/" + userID).
                then().
                log().all().
                extract().response();
        userID = response.jsonPath().getString("id");

        return response;
    }

    public static Response deleteUser1Response() {
        Response response = given().
                body(deleteEmployeeObject()).
                contentType(contentType).
                log().all().
                delete(ReqRes_BaseURL + "/api/users" + "/" + userID).
                then().
                log().all().
                extract().response();
        userID = response.jsonPath().getString("id");


        return response;


    }
}