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
    @Test(priority = 1)
    public void CreateUserTests() {
        createUserResponse().
                then().
                assertThat().
                statusCode(Creation_Success);
    }

    @Description("As an api user i want to add an address to the employee")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void UpdateEmployeeTests() {
        updateEmployeeResponse().
                then().
                assertThat().
                statusCode(Update_Success);
    }


    @Description("As an api user i want to change job title to the employee")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void PartialUpdateEmployeeTests() {
        partialUpdateEmployeeResponse().
                then().
                assertThat().
                statusCode(PartialUpdate_Success);
    }


    @Description("As an api user i want to delete the employee")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void DeleteEmployeeTests() {
        deleteEmployeeResponse().
                then().
                assertThat().
                statusCode(delete_Success);
    }

}
