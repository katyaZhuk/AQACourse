package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EditAddressHelper {

    static Properties properties = new Properties();

    private static void loadFile() throws IOException {
        properties.load(new FileInputStream("src/main/resources/properties_files/edit_address.properties"));
    }

    public static String getNewAddress() throws IOException {
        loadFile();
        return properties.getProperty("address");
    }

    public static String getNewCity() throws IOException {
        loadFile();
        return properties.getProperty("city");
    }

    public static String getNewZipCode() throws IOException {
        loadFile();
        return properties.getProperty("zip_code");
    }

}
