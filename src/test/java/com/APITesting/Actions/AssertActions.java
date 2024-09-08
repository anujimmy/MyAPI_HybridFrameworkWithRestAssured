package com.APITesting.Actions;

import com.APITesting.Payloads.Requests.Booking;
import com.APITesting.Payloads.Response.BookingResponse;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;


public class AssertActions {



    public void verifyStatusCode(Response response){
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"),true,
                "value of status code : "+ response.getStatusCode());

    }
    public void verifyStatusCode(Response response,String expStatusCode){
        assertEquals(String.valueOf(response.getStatusCode()).equalsIgnoreCase(expStatusCode),true,
                "value of status code : "+ response.getStatusCode());
    }
    public void verifyStatusCode(Response response,int expiStatusCode){
        String expStatusCode = String.valueOf(expiStatusCode);
        assertEquals(String.valueOf(response.getStatusCode()).equalsIgnoreCase(expStatusCode),true,
                "value of status code : "+ response.getStatusCode());
    }

    public void verifyResponseBody(String act, String exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void verifyResponseBody(float act, float exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void verifyResponseBody(double act, double exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void verifyResponseBody(boolean act, boolean exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void verifyResponseBody(int act, int exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void verifyNotNull(String s,String desc){
        assertNotNull(s, desc);
    }
    public void verifyNotNull(Integer s,String desc){
        assertNotNull(s, desc);
    }

    public void validateRequestNResponse(Booking updateResponse, Booking requestbody){
        assertThat(updateResponse.getFirstname()).isNotEmpty().isEqualTo(requestbody.getFirstname());
        assertThat(updateResponse.getLastname()).isNotEmpty().isEqualTo(requestbody.getLastname());
        assertThat(updateResponse.getDepositpaid()).isEqualTo(requestbody.getDepositpaid());
        assertThat(updateResponse.getTotalprice()).isNotNull().isEqualTo(requestbody.getTotalprice());
        assertThat(updateResponse.getAdditionalneeds()).isNotEmpty().isNotEmpty().isEqualTo(requestbody.getAdditionalneeds());
        assertThat(updateResponse.getBookingdates().getCheckin()).isNotEmpty().isEqualTo(requestbody.getBookingdates().getCheckin());
        assertThat(updateResponse.getBookingdates().getCheckout()).isNotEmpty().isEqualTo(requestbody.getBookingdates().getCheckout());
    }

    public void validateRequestNResponse(BookingResponse updateResponse, Booking requestbody){
        assertThat(updateResponse.getBookingid()).isNotNull();
        assertThat(updateResponse.getBooking().getFirstname()).isNotEmpty().isEqualTo(requestbody.getFirstname());
        assertThat(updateResponse.getBooking().getLastname()).isNotEmpty().isEqualTo(requestbody.getLastname());
        assertThat(updateResponse.getBooking().getDepositpaid()).isEqualTo(requestbody.getDepositpaid());
        assertThat(updateResponse.getBooking().getTotalprice()).isNotNull().isEqualTo(requestbody.getTotalprice());
        assertThat(updateResponse.getBooking().getAdditionalneeds()).isNotEmpty().isNotEmpty().isEqualTo(requestbody.getAdditionalneeds());
        assertThat(updateResponse.getBooking().getBookingdates().getCheckin()).isNotEmpty().isEqualTo(requestbody.getBookingdates().getCheckin());
        assertThat(updateResponse.getBooking().getBookingdates().getCheckout()).isNotEmpty().isEqualTo(requestbody.getBookingdates().getCheckout());
    }

}
