package lab12.task2;

import java.util.concurrent.ThreadLocalRandom;

import static lab12.task2.JsonPlaceholderClient.createResource;
import static lab12.task2.JsonPlaceholderClient.getResource;

public class Main {
    public static void main(String[] args) {
        int randomId = ThreadLocalRandom.current().nextInt(1, 101);
        getResource(randomId);

        String newPostJson = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
        createResource(newPostJson);
    }
}
