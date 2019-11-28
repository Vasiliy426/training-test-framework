package data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class DataHandler {

    private static final String USER_DATA_FILE = "test_data/json/users/users.json";

    public static Credentials getCredentials() {
        Credentials credentials = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL url = DataHandler.class.getClassLoader().getResource(USER_DATA_FILE);
            String path = Objects.requireNonNull(url).getPath();
            credentials = objectMapper.readValue(new File(path), Credentials.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

}
