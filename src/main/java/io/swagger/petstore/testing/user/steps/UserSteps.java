package io.swagger.petstore.testing.user.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import io.swagger.petstore.testing.user.controllers.UserController;
import io.swagger.petstore.testing.user.models.apiResponse.ApiResponse;
import io.swagger.petstore.testing.user.models.user.User;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserSteps extends UserController {

    @Step("Создание юзера")
    public UserSteps createUser(User user) {
        Response response = postUser(user);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Удаление юзера")
    public UserSteps deleteUserByName(String user) {
        Response response = deleteUser(user);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Проверка полей {expectedUser}")
    public UserSteps assertUserData(User expectedUser) {
        User user = getUserByName(expectedUser.getUsername());
        assertThat(user, equalTo(user));
        return this;
    }

    @Step("Успешное получение user по {userName}")
    public User getUserByName(String user) {
        Response response = getUserName(user);
        assertStatusCode(HttpStatus.SC_OK, response);
        return response.as(User.class);
    }

    @Step("User не найден по id")
    public UserSteps getNotFoundUserByName(String userName) {
        Response response = getUserName(userName);
        assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
        assertErrorMessage("User not found", response.as(ApiResponse.class));
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
