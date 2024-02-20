package io.swagger.petstore.testing.user.utils;


import io.swagger.petstore.testing.user.models.user.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import static com.sun.tools.classfile.Module_attribute.RequiresEntry.length;

public class TestGenerator {

    public static User generateUser() {
        return User.builder()
                .id(getRandomInt())
                .username(getRandomString())
                .firstName(getRandomString())
                .lastName(getRandomString())
                .email(getRandomEmail())
                .password(getRandomString())
                .phone(getRandomString())
                .userStatus(getRandomInt())
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
        return RandomStringUtils.randomAlphabetic(30);
    }

    public static String getRandomEmail() {

        String email = "mail"+RandomStringUtils.randomNumeric(length) + "@gmail.com";
        return email;
    }

}
