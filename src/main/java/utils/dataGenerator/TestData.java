package utils.dataGenerator;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();



    public static String  getRandomName(){

        return faker.name().username();
    }

    public static int  getRandomPrice(){

        return faker.number().numberBetween(1000,100000);
    }

}
