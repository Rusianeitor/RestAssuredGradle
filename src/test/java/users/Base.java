package users;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("users/"+env+"/usersApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
