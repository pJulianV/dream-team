package controller

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class apiController {
    String BASE_URL = "https://serpapi.com/search.json?";
    String API_KEY = "yourAPIKey"; // Cambiar por tu ApiKey
    String PROFILE_ENGINE = "engine=google_scholar_profiles";
    String AUTHOR_ENGINE = "engine=google_scholar_author";

    public String getByName(String name) throws Exception {
        StringBuilder response = new StringBuilder();
        URL url = new URL(BASE_URL + PROFILE_ENGINE + "&api_key=" + API_KEY + "&mauthors=" + name);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = reader.readLine()) != null) {
            response.append(linea);
        }
        reader.close();
        return response.toString();
    }

    public String getByID(String author_id) throws Exception {
        StringBuilder response = new StringBuilder();
        URL url = new URL(BASE_URL + AUTHOR_ENGINE + "&api_key=" + API_KEY + "&author_id=" + author_id);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = reader.readLine()) != null) {
            response.append(linea);
        }
        reader.close();
        return response.toString();
    }
}
