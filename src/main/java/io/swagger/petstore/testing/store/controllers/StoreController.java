package io.swagger.petstore.testing.store.controllers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;


public class StoreController {


    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
        .log(LogDetail.ALL)
        .setContentType(ContentType.JSON)
        .addFilter(new AllureRestAssured())
        .addHeader("api_key", "1234")
        .build();


    public Response getOrder(String orderId) {
        return given(requestSpecification)
            .when()
            .get(orderId);
    }

    public Response postOrder(Object order) {
        return given(requestSpecification)
            .when()
            .body(order)
            .post();
    }

    public Response deleteOrder(String order) {
        return given(requestSpecification)
            .when()
            .delete(order);
    }




}
