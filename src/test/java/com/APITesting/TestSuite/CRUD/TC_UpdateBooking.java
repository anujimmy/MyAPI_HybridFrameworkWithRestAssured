package com.APITesting.TestSuite.CRUD;

import com.APITesting.Actions.AssertActions;
import com.APITesting.Base.BaseTest;
import com.APITesting.Constants.APIContentType;
import com.APITesting.Modules.PayloadManager;
import com.APITesting.Modules.ResponseManager;
import com.APITesting.Payloads.Requests.Booking;
import com.APITesting.Payloads.Response.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static com.APITesting.Constants.EndPoints.base_PATH_UpdateBooking;


public class TC_UpdateBooking extends BaseTest {

    @Test(groups = {"CRUD","P0","QA","PREPROD","TC_PUT_UPDATEBOOKING_001"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_POST_UPDATEBOOKING-001 - Update the booking id & validate response 200")

    public void UpdateBooking_200(Integer bookingId, String tokenId ) throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();

        String req = payloadManager.createPayload_CreateRequest(); //Name is created via faker so same class can be reusued

        requestSpecification.basePath(base_PATH_UpdateBooking + "/" + bookingId.toString());
        requestSpecification.accept(APIContentType.GSON.getContentType());
        requestSpecification.cookie("token",tokenId);
        requestSpecification.body(req);

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();

        actions.verifyStatusCode(response,200);

        Booking updateResponse = responseManager.JsonToObject_Booking(response.asString());
        Booking requestbody = responseManager.JsonToObject_Booking(req);

        actions.validateRequestNResponse(updateResponse,requestbody);




    }

}
