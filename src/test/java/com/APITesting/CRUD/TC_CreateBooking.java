package com.APITesting.CRUD;
import com.APITesting.Actions.AssertActions;
import com.APITesting.Base.BaseTest;
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

import static com.APITesting.Constants.EndPoints.*;
import static org.assertj.core.api.Assertions.*;

public class TC_CreateBooking extends BaseTest {

//    public PayloadManager payloadManager;
    public ResponseManager responseManager = new ResponseManager();
    public AssertActions assertActions = new AssertActions();


    @Test(groups = {"CRUD","P0","QA","PREPROD","TC_POST_CREATEBOOKING_001"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_POST_CREATEBOOKING-001 - CreateBooking should post & booking ID is generated")

    public void CreateBooking_200() throws JsonProcessingException {

        String req = new PayloadManager().createPayload_CreateRequest();

        super.requestSpecification.basePath(base_PATH_CreateBooking).body(req);
        response = super.requestSpecification.when().post();

        String responseAsString = response.asString();
        validatableResponse = response.then().log().all();
        assertActions.verifyStatusCode(response,"200");

        /*jsonPath = JsonPath.from(responseAsString);
        String strBookingID = jsonPath.getString("bookingid");*/

        BookingResponse bookingResponse = responseManager.JsonToObject_BookingResp(responseAsString);
        Booking bookingRequest = responseManager.JsonToObject_Booking(req);

        String strBookingID = String.valueOf(bookingResponse.getBookingid());

        assertActions.verifyNotNull(strBookingID,"Validate if booking ID is not null");
        assertActions.verifyResponseBody(bookingResponse.getBooking().getFirstname(),bookingRequest.getFirstname(),"Verify First name in response");

        assertThat(bookingResponse.getBooking().getFirstname().equalsIgnoreCase(bookingRequest.getFirstname()));
    }
    @Test(groups = {"CRUD1","P3","QA","TC_POST_CREATEBOOKING_002"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.MINOR)
    @Description("TC_POST_CREATEBOOKING-002 - Request is empty - CreateBooking should not post and booking ID is not generated")
    public void CreateBooking_500() throws JsonProcessingException {
        String req = "";

        super.requestSpecification.basePath(base_PATH_CreateBooking);
        super.requestSpecification.body("").log().all();;
        response = super.requestSpecification.when().post();

        String responseAsString = response.asString();
        validatableResponse = response.then().log().all();
        assertActions.verifyStatusCode(response,"500");
        assertActions.verifyResponseBody(responseAsString,"Internal Server Error","Verify if Error - Internal Server Error is generated");

    }



    public void CreateBooking_validateJsonSchema(){

    }


}
