package users;

import net.datafaker.Faker;
import users.pojos.User;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateUserPayloadFromString(String name, String job){
        String payload = "{\"name\": \""+name+"\",\"job\": \""+job+"\"}";
        return payload;
    }

    public static Map<String, Object> getCreateUserPayloadFromMap(String name, String job){
        Map<String, Object> payload = new HashMap<>();
        payload.put("name",name);
        payload.put("job",job);
        return payload;
    }

    public static Map<String, Object> getCreateUserPayloadFromMap(){
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("job", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.JOB));
        return payload;
    }

    public static User getCreateUserPaloadFromPojo(){
        return new User(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME),RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.JOB));
        /*return User
                .builder()
                .name(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
                .job(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.JOB))
                .build();*/
    }
}
