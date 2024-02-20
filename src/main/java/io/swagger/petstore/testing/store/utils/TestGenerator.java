package io.swagger.petstore.testing.store.utils;


import io.swagger.petstore.testing.store.models.store.Status;
import io.swagger.petstore.testing.store.models.store.StoreOrder;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestGenerator {

    public static StoreOrder generateOrder() {
        return StoreOrder.builder()
                .id(getRandomInt())
                .petId(getRandomInt())
                .quantity(getRandomInt())
                .shipDate(getRandomDate())
                .status(Status.randomValue())
                .complete(getBool())
                .build();
    }

    private static Integer getRandomInt() {
        return new Random().nextInt(9999999);
    }

    private static String getRandomDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return formatter.format(cal.getTime());
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static Boolean getBool() {
        return new Random().nextBoolean();

    }
}
