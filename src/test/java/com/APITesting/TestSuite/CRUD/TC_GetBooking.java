package com.APITesting.TestSuite.CRUD;

import com.APITesting.Actions.AssertActions;
import com.APITesting.Base.BaseTest;
import com.APITesting.Constants.APIContentType;
import com.APITesting.Modules.PayloadManager;
import com.APITesting.Modules.ResponseManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.APITesting.Constants.EndPoints.base_PATH_GetBooking;

public class TC_GetBooking extends BaseTest {

    @Test(groups = {"CRUD","P0","QA","PREPROD","TC_GET_GETBOOKING_001"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_GET_GETBOOKING_001 - get the booking id & validate response 404")

    public void GetBookingAfterDelete_404(Integer bookingId ) throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();



        requestSpecification.basePath(base_PATH_GetBooking + "/" + bookingId.toString()).accept(APIContentType.GSON.getContentType())
                .auth().basic("admin","password123");

        validatableResponse = RestAssured.given().spec(requestSpecification).when().get().then().log().all();

        validatableResponse.statusCode(404);

    }
}
