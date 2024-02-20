package io.swagger.petstore.testing.pet;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.pet.data.IncorrectData;
import io.swagger.petstore.testing.pet.models.pet.Pet;
import io.swagger.petstore.testing.pet.steps.PetSteps;
import io.swagger.petstore.testing.pet.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Post")
@DisplayName("Добавление pet")
public class CreatePetTest extends PathTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet minDataPet = TestGenerator.generateMinDataPet();
    private final Pet fullDataPet = TestGenerator.generateFullDataPet();

    @Test
    @DisplayName("Добавление pet с минимальным набором полей")
    public void createMinDataPet() {
        petSteps.createPetSuccessfully(minDataPet);
    }

    @Test
    @DisplayName("Добавление pet с максимальным набором полей")
    public void createFullDataPet() {
        petSteps.createPetSuccessfully(fullDataPet);
    }

    @Test
    @DisplayName("Обработка некорректного тела запроса методом post")
    public void postIncorrectJson() {
        petSteps.postBadRequest(IncorrectData.INCORRECT_JSON);
    }
}
