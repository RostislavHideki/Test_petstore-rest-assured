package io.swagger.petstore.testing.pet.models.pet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Status {
    available, pending, sold;


    private static final List<Status> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Status randomValue()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}


