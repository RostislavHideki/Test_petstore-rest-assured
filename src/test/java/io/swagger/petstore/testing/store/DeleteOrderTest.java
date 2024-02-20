package io.swagger.petstore.testing.store;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.swagger.petstore.testing.store.models.store.StoreOrder;
import io.swagger.petstore.testing.store.steps.StoreSteps;
import io.swagger.petstore.testing.store.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Pet store")
@Feature("Order")
@Story("Delete")
@DisplayName("Удаление pet")
public class DeleteOrderTest extends PathTest {

    private final StoreSteps orderSteps = new StoreSteps();
    private final StoreOrder fullData = TestGenerator.generateOrder();

    private final String notFoundId = "-1";


    @Test
    @DisplayName("Удаление заказа")
    public void deleteOrder() {
        orderSteps.createOrder(fullData)
            .deleteOrderById(fullData.getId().toString())
            .getNotFoundOrderById(fullData.getId().toString());
    }

    @Test
    @DisplayName("Попытка удаления order по несуществующему Id")
    public void deleteNotFoundPetTest() {
        orderSteps.deleteNotFoundOrderById(notFoundId);
    }
}
