package com.APITesting.Actions;

import io.restassured.response.Response;

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


}
