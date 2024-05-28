package lab12.task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class JsonPlaceholderClient {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void getResource(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println("Response for GET request:");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createResource(String json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println("Object sent:");
            System.out.println(json);
            System.out.println("Response for POST request:");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

