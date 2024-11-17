package Common;

import io.restassured.response.Response;

import static Common.BasePaths.ReqRes_BaseURL;
import static Common.ContentType.contentType;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static String userID;

    public static Response createUserResponse() {
        Response response= given().
                when().
                body(createEmployeeObject()).
                contentType(contentType).
                log().all().
                post(ReqRes_BaseURL+"/api/users").
                then().
                log().all().
                extract().response();
        userID=response.jsonPath().getString("id");


        return response;
    }


    public static Response updateEmployeeResponse() {
        return  given().
                when().
                body(updateEmployeeObject()).
                contentType(contentType).
                log().all().
                put(ReqRes_BaseURL+"/api/users/"+userID).
                then().
                log().all().
                extract().response();
    }


    public static Response partialUpdateEmployeeResponse() {
        return  given().
                when().
                body(partialUpdateEmployeeObject()).
                contentType(contentType).
                log().all().
                patch(ReqRes_BaseURL+"/api/users/"+userID).
                then().
                log().all().
                extract().response();
    }


    public static Response deleteEmployeeResponse() {
        return  given().
                when().
                contentType(contentType).
                log().all().
                delete(ReqRes_BaseURL+"/api/users/"+userID).
                then().
                log().all().
                extract().response();
    }


}
