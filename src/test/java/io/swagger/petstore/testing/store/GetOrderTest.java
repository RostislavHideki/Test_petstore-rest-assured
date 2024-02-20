package io.swagger.petstore.testing.store;


import io.swagger.petstore.testing.store.models.store.StoreOrder;
import io.swagger.petstore.testing.store.steps.StoreSteps;
import io.swagger.petstore.testing.store.utils.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


@DisplayName("Получение pet")
public class GetOrderTest extends PathTest {

    private final StoreSteps orderSteps = new StoreSteps();
    private final StoreOrder fullDataOrder = TestGenerator.generateOrder();
    private final String notFoundId = "-1";



    @Test
    @DisplayName("Получить заказ")
    public void getOrderTest() {
        orderSteps.createOrder(fullDataOrder).assertOrderData(fullDataOrder);
    }
}
