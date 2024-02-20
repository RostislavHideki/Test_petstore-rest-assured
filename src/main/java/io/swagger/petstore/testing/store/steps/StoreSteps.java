package io.swagger.petstore.testing.store.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;


import io.swagger.petstore.testing.store.controllers.StoreController;
import io.swagger.petstore.testing.store.models.apiResponse.ApiResponse;
import io.swagger.petstore.testing.store.models.store.StoreOrder;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StoreSteps extends StoreController {

    @Step("Создание заказа /store/order")
    public StoreSteps createOrder(StoreOrder order) {
        Response response = postOrder(order);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Успешное получение order по Id")
    public StoreOrder getOrderById(String order) {
        Response response = getOrder(order);
        assertStatusCode(HttpStatus.SC_OK, response);
        return response.as(StoreOrder.class);
    }

    @Step("Проверка полей {expectedOrder}")
    public StoreSteps assertOrderData(StoreOrder expectedOrder) {
        StoreOrder order = getOrderById(expectedOrder.getId().toString());
        assertThat(order, equalTo(order));
        return this;
    }

    @Step("Order не найден по id")
    public StoreSteps getNotFoundOrderById(String orderId) {
        Response response = getOrder(orderId);
        assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
        assertErrorMessage("Order not found", response.as(ApiResponse.class));
        return this;
    }

    @Step("Успешное удаление существующего заказа по id {orderId}")
    public StoreSteps deleteOrderById(String orderId) {
        Response response = deleteOrder(orderId);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }
    @Step("Post невалидного объекта")
    public StoreSteps postBadRequest(Object order) {
        Response response = postOrder(order);
        assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
        return this;
    }

    @Step("Попытка удаления несуществующего pet по id {orderId}")
    public StoreSteps deleteNotFoundOrderById(String orderId) {
        Response response = deleteOrder(orderId);
        assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
        return this;
    }

    @Step("Проверка статус кода")
    private void assertStatusCode(int ExpectedStatus, Response response) {
        assertThat(response.statusCode(), equalTo(ExpectedStatus));
    }

    @Step("Проверка сообщения")
    public void assertErrorMessage(String expectedMessage, ApiResponse apiResponse) {
        assertThat(apiResponse.getMessage(), equalTo(expectedMessage));
    }



}
