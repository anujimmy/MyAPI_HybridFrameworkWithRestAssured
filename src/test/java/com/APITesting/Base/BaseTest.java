package com.APITesting.Base;

import com.APITesting.Actions.AssertActions;
import com.APITesting.Constants.APIContentType;

import com.APITesting.Modules.PayloadManager;
import com.APITesting.Modules.ResponseManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.APITesting.Constants.EndPoints.base_URL;
import static io.restassured.RestAssured.reset;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public RequestSpecBuilder requestSpecBuilder;
    public Response response;
    public ValidatableResponse validatableResponse;
    public JsonPath jsonPath;

    public ResponseManager responseManager;
    @BeforeSuite
    public void API_VerifyHealthCheck(){

        RestAssured.given().baseUri(base_URL).basePath("/ping")
                .when().get()
                .then().assertThat().statusCode(201);

    }

    @BeforeTest
    public void setUp(){
        reset();
        requestSpecification = RestAssured.given();
            requestSpecification.baseUri(base_URL);
            requestSpecification.contentType(APIContentType.GSON.getContentType());


        /*RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            requestSpecBuilder.setBaseUri(base_URL);
            requestSpecBuilder.setContentType(APIContentType.GSON.getContentType());*/

    }

    @AfterTest
    public void resetRestAssured(){
        reset();
    }
}
