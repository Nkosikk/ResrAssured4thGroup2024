package Tests.Weather;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Creation_Success;
import static Common.CommonTestData.badRequest;
import static Common.GenerateTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Weather Station")
@Story("weather")
public class weatherTest {


    @Description("As an api user i want to create the new weather station")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateWeatherStationTests() {
        weatherStationResponse(externalID, stationName, latitude, longitude, altitude).
                then().
                assertThat().
                statusCode(Creation_Success);

    }

    @Description("As an api user i want to test the creation of the new weather station without providing station name")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateWeatherStationWithEmptyStationNameTests() {
        weatherStationResponse(externalID, "", latitude, longitude, altitude).
                then().
                assertThat().
                statusCode(badRequest).
                body("code", notNullValue()).
                body("message", equalTo("Bad or zero length station name"));


    }

    @Description("As an api user i want to test the creation of the new weather station without providing latitude value")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateWeatherStationWithEmptyLatitudeTests() {
        Float lat = 0.0F;

        weatherStationResponse(externalID, stationName, lat, longitude, altitude).
                then().
                assertThat().
                statusCode(badRequest).
                body("code", notNullValue()).
                body("message", equalTo("Bad or zero length station name"));


    }
}
