package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames) {
        switch (dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.address().country();
            case JOB:
                return faker.job().position();
            default:
                return "Data type not available";
        }
    }

    public static String getRandomNumber(int count){
        return faker.number().digits(count);
    }

    public static String getRandomAlfabetic(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }
}
