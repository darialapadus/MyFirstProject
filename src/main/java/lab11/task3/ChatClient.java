package lab11.task3;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);
                if (serverResponse.equals("Enter your username:")) {
                    out.println(userInput.readLine());
                } else if (serverResponse.startsWith("Welcome, ")) {
                    break;
                }
            }

            Thread listenerThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            listenerThread.start();

            while (true) {
                String userCommand = userInput.readLine();
                System.out.println("Client command: " + userCommand);
                out.println(userCommand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}