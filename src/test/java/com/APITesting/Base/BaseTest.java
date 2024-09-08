package com.APITesting.Base;


import com.APITesting.Actions.AssertActions;
import com.APITesting.Constants.APIContentType;

import com.APITesting.Modules.PayloadManager;
import com.APITesting.Modules.ResponseManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static com.APITesting.Constants.EndPoints.*;
import static io.restassured.RestAssured.*;

public class BaseTest {

    public static RequestSpecification requestSpecification = RestAssured.given();
//    public static RequestSpecBuilder requestSpecBuilder;
    public static Response response;
    public static ValidatableResponse validatableResponse;
    public static JsonPath jsonPath;
    public static AssertActions actions;
    public static ResponseManager responseManager ;
    public static PayloadManager payloadManager;


    @BeforeSuite
    public void verifyHealthCheck(){
        RestAssured.given().baseUri(base_URL).basePath(base_PATH_HealthCheck)
                .when().get()
                .then().log().all().statusCode(201);

    }


    @BeforeMethod(alwaysRun = true)
    public void setConfig(){
            requestSpecification.baseUri(base_URL);
            requestSpecification.contentType(APIContentType.GSON.getContentType());
        /*RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            requestSpecBuilder.setBaseUri(base_URL);
            requestSpecBuilder.setContentType(APIContentType.GSON.getContentType());*/

    }


    public String getToken() throws Exception {
        String req = new PayloadManager().createPayload_getToken();
        requestSpecification.basePath(base_PATH_GetToken);
        requestSpecification.body(req);

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        String responseAsString = response.asString();
        enableLoggingOfRequestAndResponseIfValidationFails();
        jsonPath = new JsonPath(responseAsString);

        String tokenID = jsonPath.getString("token");

        return tokenID;

    }



}
