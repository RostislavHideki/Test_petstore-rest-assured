package io.swagger.petstore.testing.user.controllers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class UserController {


    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
        .log(LogDetail.ALL)
        .setContentType(ContentType.JSON)
        .addFilter(new AllureRestAssured())
        .addHeader("api_key", "1234")
        .build();


    public Response getUserName(String userName) {
        return given(requestSpecification)
            .when()
            .get(userName);
    }

    public Response postUser(Object user) {
        return given(requestSpecification)
            .when()
            .body(user)
            .post();
    }

    public Response deleteUser(String user) {
        return given(requestSpecification)
            .when()
            .delete(user);
    }




}
