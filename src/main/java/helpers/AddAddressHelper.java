package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AddAddressHelper {

    static Properties properties = new Properties();

    private static void loadFile() throws IOException {
        properties.load(new FileInputStream("src/main/resources/properties_files/add_address.properties"));
    }

    public static String getName() throws IOException {
        loadFile();
        return properties.getProperty("name");
    }

    public static String getLastName() throws IOException {
        loadFile();
        return properties.getProperty("last_name");
    }

    public static String getAddress() throws IOException {
        loadFile();
        return properties.getProperty("address");
    }

    public static String getCity() throws IOException {
        loadFile();
        return properties.getProperty("city");
    }

    public static String getZipCode() throws IOException {
        loadFile();
        return properties.getProperty("zip_code");
    }

}
