package com.APITesting.TestSuite.CRUD;

import com.APITesting.Actions.AssertActions;
import com.APITesting.Base.BaseTest;
import com.APITesting.Modules.PayloadManager;
import com.APITesting.Modules.ResponseManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.APITesting.Constants.EndPoints.*;

public class TC_DeleteBooking extends BaseTest {

    @Test(groups = {"CRUD","P0","QA","PREPROD","TC_DELETE_DELETEBOOKING_001"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_POST_DELETEBOOKING-001 - DELETE the booking id & validate response 200")

    public void DeleteBooking_201(Integer bookingId, String tokenId ) throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();

        requestSpecification.basePath(base_PATH_GetBooking + "/" + bookingId.toString()).accept("").body("")
                            .cookie("token",tokenId);

        response = RestAssured.given().spec(requestSpecification).when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
