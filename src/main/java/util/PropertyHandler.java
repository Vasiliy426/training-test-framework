package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static util.Constants.APP_PROPERTIES_PATH;

public class PropertyHandler {

    public static void readProperties() {
        Properties pr = new Properties(System.getProperties());
        try {
            FileInputStream inp = new FileInputStream(APP_PROPERTIES_PATH);
            pr.load(inp);
            System.setProperties(pr);
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
