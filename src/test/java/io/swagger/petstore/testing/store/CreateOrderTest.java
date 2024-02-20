package io.swagger.petstore.testing.store;

import io.swagger.petstore.testing.store.models.store.StoreOrder;
import io.swagger.petstore.testing.store.steps.StoreSteps;
import io.swagger.petstore.testing.store.utils.TestGenerator;
import io.swagger.petstore.testing.store.data.IncorrectData;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




@DisplayName("Создание заказа")
public class CreateOrderTest extends PathTest {

    private final StoreSteps orderSteps = new StoreSteps();
    private final StoreOrder fullDataOrder = TestGenerator.generateOrder();


    @Test
    @DisplayName("Создание заказа")
    public void createOrder() {
        orderSteps.createOrder(fullDataOrder);
    }

    @Test
    @DisplayName("Обработка некорректного тела запроса методом post")
    public void postIncorrectJson() {
        orderSteps.postBadRequest(IncorrectData.INCORRECT_JSON);
    }

}
