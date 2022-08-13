package practicing.io.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practicing.io.handler.DataHandler;

public class JsonUnmarshallService implements UnmarshallService {
    private ObjectMapper objectMapper;

    public JsonUnmarshallService() {
        objectMapper = new ObjectMapper();
    }
    @Override
    public <T> T unmarshall(String stringToUnmarshall, Class<T> type){
        try{
            T unmarshalled = objectMapper.readValue(stringToUnmarshall, type);
            return unmarshalled;
        }
        catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String marshall(Object objectToMarshall){
        try {
            String marshalled = objectMapper.writeValueAsString(objectToMarshall);
            return marshalled;
        }
        catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
