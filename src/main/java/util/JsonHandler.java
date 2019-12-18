package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class JsonHandler {

    public static <T> T fromStringToObject(String path, Class<T> type) {
        T result = null;
        try {
            URL url = JsonHandler.class.getClassLoader().getResource(path);
            String fullPath = Objects.requireNonNull(url).getPath();
            result = new ObjectMapper().readValue(new File(fullPath), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
