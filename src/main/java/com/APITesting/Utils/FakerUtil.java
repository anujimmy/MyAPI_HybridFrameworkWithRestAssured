package com.APITesting.Utils;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class FakerUtil {
    private static final Logger log = LogManager.getLogger(FakerUtil.class);
    static Faker faker = new Faker();

    public static String getFirstName(){
        String s =  faker.name().firstName();
        log.info("First name created via Faker - " + s);
        return s;
    }
    public static String getLastName(){
        String s =  faker.name().lastName();
        log.info("Last name created via Faker - " + s);
        return faker.name().lastName();
    }

    public static String getCheckinDate(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        return formatter.format (faker.date ().past (20, TimeUnit.DAYS));
    }
    public static String getCheckoutDate(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        return formatter.format (faker.date ().future (5, TimeUnit.DAYS));
    }
}
