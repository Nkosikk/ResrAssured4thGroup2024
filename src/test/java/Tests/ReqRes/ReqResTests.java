package Tests.ReqRes;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.RequestBuilder.*;
import static Common.TestData.*;

@Test
@Feature("Req Res")
@Story("Employees")
public class ReqResTests {


    @Description("As an api user i want to create the new employee")
    @Severity(SeverityLevel.BLOCKER)

    public void CreateUserTests() {
        createUserResponse().
                then().
                assertThat().
                statusCode(Creation_Success);
    }

    @Description("As an api user i want to update the address on a new employee")
    @Severity(SeverityLevel.MINOR)

    public void UpdateUserTest() {
        updateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status);
    }

    @Description("As an api user i want to update the name of the name of a new employee")
    @Severity(SeverityLevel.CRITICAL)
    public void Update1UserTest() {
        updateUser1Response().
                then().
                assertThat().
                statusCode(Success_Status);
    }

    @Description("As an api user i want to Delete updated employee")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteUser1Test() {
        deleteUser1Response().
                then().
                assertThat().
                statusCode(Delete_Success);
    }
}
