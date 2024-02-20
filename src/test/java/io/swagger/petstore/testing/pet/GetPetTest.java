package io.swagger.petstore.testing.pet;

import io.swagger.petstore.testing.pet.models.pet.Pet;
import io.swagger.petstore.testing.pet.steps.PetSteps;
import io.swagger.petstore.testing.pet.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Получение pet")
public class GetPetTest extends PathTest {

    private final PetSteps petSteps = new PetSteps();
    private final Pet fullDataPet = TestGenerator.generateFullDataPet();
    private final String notFoundId = "-1";

    @Test
    @DisplayName("Получить pet")
    public void getPetTest() {
        petSteps.createPetSuccessfully(fullDataPet).assertPetData(fullDataPet);
    }

    @Test
    @DisplayName("Попытка получить pet по несуществующему Id")
    public void getNotFoundPetTest() {
        petSteps.getNotFoundPetById(notFoundId);
    }
}
