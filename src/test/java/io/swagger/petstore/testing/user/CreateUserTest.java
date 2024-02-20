package io.swagger.petstore.testing.user;

import io.swagger.petstore.testing.user.utils.TestGenerator;
import io.swagger.petstore.testing.user.models.user.User;
import io.swagger.petstore.testing.user.steps.UserSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Создание пользователя")
public class CreateUserTest extends PathTest {

    private final UserSteps userSteps = new UserSteps();

    private final User userGenerate = TestGenerator.generateUser();



    @Test
    @DisplayName("Создание пользователя")
    public void createUser() {
       userSteps.createUser(userGenerate);
    }



}
