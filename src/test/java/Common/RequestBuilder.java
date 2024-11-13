package Common;

import io.restassured.response.Response;

import static Common.BasePaths.ReqRes_BaseURL;
import static Common.ContentType.contentType;
import static Common.PayloadBuilder.createEmployeeObject;
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


}
