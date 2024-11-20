package Tests.Weather;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Creation_Success;
import static Common.GenerateTestData.firstName;
import static Common.GenerateTestData.jobTime;
import static Common.RequestBuilder.createUserResponse;
import static Common.RequestBuilder.createWeatherStationResponse;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

    @Test
    @Feature("Weather Station")
    @Story("weather")
    public class weatherTest {


        @Description("As an api user i want to create the new weather station")
        @Severity(SeverityLevel.BLOCKER)
        public void CreateWeatherStationTests() {
            createWeatherStationResponse().
                    then().
                    assertThat().
                    statusCode(Creation_Success);

        }

}
