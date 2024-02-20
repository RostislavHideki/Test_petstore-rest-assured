package io.swagger.petstore.testing.user;



import io.swagger.petstore.testing.user.models.user.User;
import io.swagger.petstore.testing.user.steps.UserSteps;
import io.swagger.petstore.testing.user.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;


@DisplayName("Получение pet")
public class GetUserTest extends PathTest {

    private final UserSteps userSteps = new UserSteps();
    private final User userData = TestGenerator.generateUser();


    @Test
    @DisplayName("Получить заказ")
    public void getUserTest() {
        userSteps.createUser(userData).assertUserData(userData);
    }
}
