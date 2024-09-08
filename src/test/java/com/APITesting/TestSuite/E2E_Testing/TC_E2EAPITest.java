package com.APITesting.TestSuite.E2E_Testing;

import com.APITesting.Base.BaseTest;
import com.APITesting.TestSuite.CRUD.TestCase_CreateBooking;
import com.APITesting.TestSuite.CRUD.TC_DeleteBooking;
import com.APITesting.TestSuite.CRUD.TC_GetBooking;
import com.APITesting.TestSuite.CRUD.TC_UpdateBooking;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TC_E2EAPITest extends BaseTest {

    public String token;
    public Integer bookingId;

    private static final Logger log = LogManager.getLogger(TC_E2EAPITest.class);

    @Test(groups = {"P0","E2E"})
    public void post_CreateBooking() throws JsonProcessingException {
        log.info("-------------------Executing Create Booking -----------------");
        bookingId = new TestCase_CreateBooking().CreateNReturnBooking_200();

    }
    @Test(groups = {"P0","E2E"},dependsOnMethods = {"post_CreateBooking"})
    public void put_UpdateBooking() throws Exception {
        log.info("-------------------Executing Update Booking -----------------");
        token = getToken();
        new TC_UpdateBooking().UpdateBooking_200(bookingId,token);

    }
    @Test(groups = {"P0","E2E"},dependsOnMethods = {"post_CreateBooking","put_UpdateBooking"})
    public void delete_DeleteBooking() throws JsonProcessingException {
        log.info("-------------------Executing Delete Booking -----------------");
        new TC_DeleteBooking().DeleteBooking_201(bookingId,token);
    }
    @Test(groups = {"P0","E2E"},dependsOnMethods = {"delete_DeleteBooking"})
    public void get_getBookingAfterDeleteBooking() throws JsonProcessingException {
        log.info("-------------------Executing Get Booking -----------------");
        new TC_GetBooking().GetBookingAfterDelete_404(bookingId);
    }
}
