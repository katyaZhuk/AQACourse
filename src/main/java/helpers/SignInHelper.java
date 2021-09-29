package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SignInHelper {

    static Properties properties = new Properties();

    private static void loadFile() throws IOException {
        properties.load(new FileInputStream("src/main/resources/properties_files/credentials.properties"));
    }

    public static String getURL() throws IOException {
        loadFile();
        return properties.getProperty("url");
    }

    public static String getEmail() throws IOException {
        loadFile();
        return properties.getProperty("email");
    }

    public static String getPassword() throws IOException {
        loadFile();
        return properties.getProperty("password");
    }

    public static String getHomePageTitle() throws IOException {
        loadFile();
        return properties.getProperty("home_page_title");
    }

    public static String getLoginPageTitle() throws IOException {
        loadFile();
        return properties.getProperty("login_page_title");
    }

}
