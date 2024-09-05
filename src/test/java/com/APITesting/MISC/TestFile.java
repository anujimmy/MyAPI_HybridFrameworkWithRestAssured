package com.APITesting.MISC;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestFile {

    @Test(groups = "P0")
    public void mytest(){
        String payloadAuth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


            RestAssured
                    .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
//                    .baseUri(E_API_BaseURL.RESTFULLBOOKER.getBaseURL())
                    .basePath("auth")
                    .contentType("application/json")
//                    .contentType(E_API_ContentType.GSON.getContentType()[0])
                    .when().body(payloadAuth).post()
                    .then().log().all().statusCode(200);
        }


}
