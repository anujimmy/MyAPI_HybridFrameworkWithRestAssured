package com.APITesting.Actions;

import io.restassured.response.Response;

import static org.testng.Assert.*;

public class AssertActions {

    public void verifyStatusCode(Response response){
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"),true,
                "value of status code : "+ response.getStatusCode());

    }
    public void verifyStatusCode(Response response,String expStatusCode){
        assertEquals(String.valueOf(response.getStatusCode()).startsWith(expStatusCode),true,
                "value of status code : "+ response.getStatusCode());
    }
    public void VerifyResponseBody(String act, String exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void VerifyResponseBody(float act, float exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void VerifyResponseBody(double act, double exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void VerifyResponseBody(boolean act, boolean exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void VerifyResponseBody(int act, int exp, String desc){
        assertEquals(act,exp,desc);
    }
    public void VerifyNotNull(String val,String desc){
        assertNotNull(val,desc);
    }
    public void VerifyNotNull(Integer val,String desc){
        assertNotNull(val,desc);
    }
    public void VerifyNotNull(int val,String desc){
        assertNotNull(val,desc);
    }
    public void VerifyNotNull(float val,String desc){
        assertNotNull(val,desc);
    }
    public void VerifyNotNull(double val,String desc){
        assertNotNull(val,desc);
    }
}
