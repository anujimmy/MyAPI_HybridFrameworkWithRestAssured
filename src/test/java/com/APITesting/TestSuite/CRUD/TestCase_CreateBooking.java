package com.APITesting.TestSuite.CRUD;
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
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static com.APITesting.Constants.EndPoints.*;

public class TestCase_CreateBooking extends BaseTest {

    @Test(groups = {"CRUD","P0","QA","PREPROD","TC_POST_CREATEBOOKING_001"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC_POST_CREATEBOOKING-001 - CreateBooking should post & booking ID is generated")

    public void CreateBooking_200() throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();

        String req = payloadManager .createPayload_CreateRequest();

        requestSpecification.basePath(base_PATH_CreateBooking).body(req);
        response = requestSpecification.when().post();

        String responseAsString = response.asString();
        validatableResponse = response.then().log().all();
        actions.verifyStatusCode(response,"200");

        /*jsonPath = JsonPath.from(responseAsString);
        String strBookingID = jsonPath.getString("bookingid");*/

        BookingResponse bookingResponse = responseManager.JsonToObject_BookingResp(responseAsString);
        Booking bookingRequest = responseManager.JsonToObject_Booking(req);

        Integer strBookingID = bookingResponse.getBookingid();

        actions.validateRequestNResponse(bookingResponse,bookingRequest);
    }

    @Test(groups = {"CRUD1","P3","QA","TC_POST_CREATEBOOKING_002"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.MINOR)
    @Description("TC_POST_CREATEBOOKING-002 - Request is empty - CreateBooking should not post and booking ID is not generated")
    public void CreateBooking_500() throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();

        requestSpecification.basePath(base_PATH_CreateBooking);
        requestSpecification.body("").log().all();
        response = super.requestSpecification.when().post();

        String responseAsString = response.asString();
        validatableResponse = response.then().log().all();
        actions.verifyStatusCode(response,"500");
        actions.verifyResponseBody(responseAsString,"Internal Server Error","Verify if Error - Internal Server Error is generated");

    }
    @Test(groups = {"CRUD1","E2E_Component","QA","TC_POST_CREATEBOOKING_003"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_POST_CREATEBOOKING-002 - Request is empty - CreateBooking booking ID is generated & returned ")
    public Integer CreateNReturnBooking_200() throws JsonProcessingException {

        actions = new AssertActions();
        responseManager = new ResponseManager();
        payloadManager = new PayloadManager();

        String req = payloadManager.createPayload_CreateRequest();

        requestSpecification.basePath(base_PATH_CreateBooking).body(req);
        response = requestSpecification.when().post();

        String responseAsString = response.asString();
        validatableResponse = response.then().log().all();
        actions.verifyStatusCode(response,"200");

        /*jsonPath = JsonPath.from(responseAsString);
        String strBookingID = jsonPath.getString("bookingid");*/

        BookingResponse bookingResponse = responseManager.JsonToObject_BookingResp(responseAsString);
        Booking bookingRequest = responseManager.JsonToObject_Booking(req);

        Integer strBookingID = bookingResponse.getBookingid();
        actions.validateRequestNResponse(bookingResponse,bookingRequest);
        return strBookingID;
    }
    @Test(groups = {"Schema","P0","QA","TC_POST_CREATEBOOKING_003"})
    @Owner("Anu Jimmy")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_POST_CREATEBOOKING-003 - Validate schema for Create Booking")
    public void validateJsonSchema() throws JsonProcessingException {

        String req = payloadManager.createPayload_CreateRequest();
        requestSpecification.basePath(base_PATH_CreateBooking).body(req);
        response = requestSpecification.when().post();
        validatableResponse = response.then().statusCode(200);

        validatableResponse.and().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/java/com/APITesting/resources/schema_CreateBooking.json")));

    }

}
