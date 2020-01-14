package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonHandler {

    public static <T> T fromStringToObject(String path, Class<T> type) {
        T result = null;
        try {
            result = new ObjectMapper().readValue(new File(path), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
