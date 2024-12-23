package sampleapp;

import java.net.HttpURLConnection;
import java.net.URL;

public class SSLTest {
    public static void main(String[] args) {
        String website = "https://magento.softwaretestingboard.com/";

        try {
            URL url = new URL(website);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000); // Set timeout
            connection.connect();

            if (connection.getURL().getProtocol().equals("https")) {
                System.out.println("The website is SSL-secured.");
            } else {
                System.out.println("The website is not SSL-secured.");
            }
        } catch (Exception e) {
            System.out.println("Error in SSL Test: " + e.getMessage());
        }
    }
}
