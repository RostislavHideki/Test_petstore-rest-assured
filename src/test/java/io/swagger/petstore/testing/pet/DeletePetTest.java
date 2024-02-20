package io.swagger.petstore.testing.pet;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.pet.models.pet.Pet;
import io.swagger.petstore.testing.pet.steps.PetSteps;
import io.swagger.petstore.testing.pet.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Pet")
@Story("Delete")
@DisplayName("Удаление pet")
public class DeletePetTest extends PathTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestGenerator.generateFullDataPet();
    private final String notFoundId = "-1";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление pet")
    public void deletePet() {
        petSteps.createPetSuccessfully(fullDataPet)
            .deletePetById(fullDataPet.getId().toString())
            .getNotFoundPetById(fullDataPet.getId().toString());
    }

    @Test
    @DisplayName("Попытка удаления pet по несуществующему Id")
    public void deleteNotFoundPetTest() {
        petSteps.deleteNotFoundPetById(notFoundId);
    }
}
