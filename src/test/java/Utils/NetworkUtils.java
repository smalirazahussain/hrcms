package Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    public static boolean isInternetAvailable(String testUrl) {
        try {
            URL url = new URL(testUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            return connection.getResponseCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }
}
