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
}
