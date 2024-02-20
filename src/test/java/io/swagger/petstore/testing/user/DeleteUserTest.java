package io.swagger.petstore.testing.user;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import io.swagger.petstore.testing.user.utils.TestGenerator;
import io.swagger.petstore.testing.user.models.user.User;
import io.swagger.petstore.testing.user.steps.UserSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Order")
@Story("Delete")
@DisplayName("Удаление pet")
public class DeleteUserTest extends PathTest {

    private final UserSteps user = new UserSteps();
    private final User fullDataUser = TestGenerator.generateUser();


    @Test
    @DisplayName("Удаление юзера")
    public void deleteUser() {
            user.createUser(fullDataUser)
            .deleteUserByName(fullDataUser.getUsername())
            .getNotFoundUserByName(fullDataUser.getUsername());
    }
}
