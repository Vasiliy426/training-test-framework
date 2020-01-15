package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static util.Constants.APP_PROPERTIES_PATH;

public class PropertyHandler {

    private static Properties pr = new Properties();

    static {
        try {
            FileInputStream inp = new FileInputStream(APP_PROPERTIES_PATH);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return pr.getProperty(key);
    }

}
