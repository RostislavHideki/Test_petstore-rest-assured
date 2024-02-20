package io.swagger.petstore.testing.pet;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.pet.data.IncorrectData;
import io.swagger.petstore.testing.pet.models.pet.Pet;
import io.swagger.petstore.testing.pet.models.pet.Status;
import io.swagger.petstore.testing.pet.steps.PetSteps;
import io.swagger.petstore.testing.pet.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Put")
@DisplayName("Обновление pet")
public class UpdatePetTest extends PathTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestGenerator.generateFullDataPet();
    private final Pet modifiedPet = fullDataPet.toBuilder().name("His").id(4324).status(Status.randomValue()).build();

    @Test
    @DisplayName("Обновление данных pet")
    public void updateFullDataPet() {
        petSteps.createPetSuccessfully(fullDataPet)
            .putPetSuccessfully(modifiedPet)
            .assertPetData(modifiedPet);
    }

    @Test
    @DisplayName("Создание нового pet методом put")
    public void putNewPet() {
        petSteps.putPetSuccessfully(fullDataPet).assertPetData(fullDataPet);
    }

    @Test
    @DisplayName("Обработка некорректного тела запроса методом put")
    public void putIncorrectJson() {
        petSteps.putBadRequest(IncorrectData.INCORRECT_JSON);
    }
}
