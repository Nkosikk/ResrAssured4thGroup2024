package Tests.Weather;

import io.qameta.allure.*;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.annotations.Test;

import javax.lang.model.type.NullType;

import java.io.IOException;

import static Common.CommonTestData.*;
import static Common.GenerateTestData.*;
import static Common.RequestBuilder.*;
import static java.lang.Float.NaN;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Weather Station")
@Story("weather")
public class weatherTest {


    @Description("As an api user i want to test the creation of the new weather station without providing station name")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateWeatherStationWithEmptyStationNameTests() throws IOException {
        weatherStationResponse(externalID, "", latitude, longitude, altitude).
                then().
                assertThat().
                statusCode(badRequest).
                body("code", notNullValue()).
                body("message", equalTo("Bad or zero length station name"));


    }


    //    @Description("As an api user i want to test the creation of the new weather station without providing latitude value")
//    @Severity(SeverityLevel.BLOCKER)
//    public void CreateWeatherStationWithEmptyLatitudeTests() throws IOException {
////        float latitude = 0.0f;
//        weatherStationResponse(externalID,stationName,latitude, longitude, altitude).
//                then().
//                assertThat().
//                statusCode(badRequest).
//                body("code", notNullValue()).
//                body("message", containsString("unmarshal type error:"));
//
//
//    }
//    @Description("As an api user i want to test the creation of the new weather station without providing longitude value")
//    @Severity(SeverityLevel.BLOCKER)
//    public void CreateWeatherStationWithEmptyLongitudeTests() throws IOException {
//
//        weatherStationResponse(externalID,stationName,latitude,longitude, altitude).
//                then().
//                assertThat().
//                statusCode(badRequest).
//                body("code", notNullValue()).
//                body("message", containsString("unmarshal type error:"));
//
//
//    }
//    @Description("As an api user i want to test the creation of the new weather station without providing Altitude value")
//    @Severity(SeverityLevel.BLOCKER)
//    public void CreateWeatherStationWithEmptyAltitudeTests() throws IOException {
//
//        weatherStationResponse(externalID,stationName,latitude,longitude, altitude).
//                then().
//                assertThat().
//                statusCode(badRequest).
//                body("code", notNullValue()).
//                body("message", equalTo("Bad or zero length station name"));
//
//
//    }
//
//    @Description("As an api user i want to test the creation of the new weather station without providing External ID value")
//    @Severity(SeverityLevel.BLOCKER)
//    public void CreateWeatherStationWithEmptyAExternalIDTests() throws IOException {
//
//        weatherStationResponse(null,stationName,latitude,longitude, altitude).
//                then().
//                assertThat().
//                statusCode(badRequest).
//                body("code", notNullValue()).
//                body("message", equalTo("Bad external id"));
//
//
//    }


    @Description("As an api user i want to create the new weather station")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dependsOnMethods = "CreateWeatherStationWithEmptyStationNameTests")
    public void CreateWeatherStationTests() throws IOException {
        weatherStationResponse(externalID, stationName, latitude,longitude, altitude).
                then().
                assertThat().
                statusCode(Creation_Success);


    }


    @Description("As an api user i want to update weather station details")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dependsOnMethods = "CreateWeatherStationTests"  )
    public void UpdateWeatherDetails() throws IOException {
        updateweatherStationResponse(externalID, stationName, latitude,longitude, altitude).
                then().
                assertThat().
                statusCode(Success_Status);
    }


    @Description("As an api user i want to delete the weather station")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "UpdateWeatherDetails")
    public void DeleteWeatherStationTests() {
        deleteWeatherStationResponse().
                then().
                assertThat().
                statusCode(delete_Success);
    }
}
