package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Credentials;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static util.Constants.USER_DATA_PATH;

public class DataHandler {

    public static Credentials getCredentials() {
        Credentials credentials = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL url = DataHandler.class.getClassLoader().getResource(USER_DATA_PATH);
            String path = Objects.requireNonNull(url).getPath();
            credentials = objectMapper.readValue(new File(path), Credentials.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

}
