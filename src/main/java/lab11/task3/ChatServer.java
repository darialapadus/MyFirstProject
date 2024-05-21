package lab11.task3;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<String, Topic> topics = new HashMap<>();

    public static void main(String[] args) {
        topics.put("gatit", new Topic("gatit"));
        topics.put("programare", new Topic("programare"));

        System.out.println("Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private User user;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter your username:");
                String username = in.readLine();
                user = new User(username, out);
                out.println("Welcome, " + username + "!");

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server received: " + line);
                    handleRequest(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void handleRequest(String request) {
            String[] parts = request.split(" ", 2);
            if (parts.length < 2) {
                out.println("Invalid command.");
                return;
            }

            String command = parts[0];
            String argument = parts[1];

            switch (command) {
                case "subscribe":
                    subscribe(argument);
                    break;
                case "publish":
                    String[] pubParts = argument.split(" ", 2);
                    if (pubParts.length < 2) {
                        out.println("Invalid publish command.");
                        return;
                    }
                    String topicName = pubParts[0];
                    String message = pubParts[1];
                    publish(topicName, message);
                    break;
                default:
                    out.println("Unknown command.");
            }
        }

        private void subscribe(String topicName) {
            Topic topic = topics.get(topicName);
            if (topic == null) {
                out.println("Topic not found.");
                return;
            }
            topic.addSub(user);
            out.println("Subscribed to " + topicName);
        }

        private void publish(String topicName, String message) {
            Topic topic = topics.get(topicName);
            if (topic == null) {
                out.println("Topic not found.");
                return;
            }
            topic.publish(message, user);
        }
    }
}

class Topic {
    private String topName;
    private List<User> subs;

    public Topic(String topName) {
        this.topName = topName;
        this.subs = new ArrayList<>();
    }

    public void addSub(User user) {
        subs.add(user);
    }

    public void publish(String message, User sender) {
        for (User user : subs) {
            user.sendNotify(message, topName, sender.getUsername());
        }
    }
}

class User {
    private String username;
    private PrintWriter out;

    public User(String username, PrintWriter out) {
        this.username = username;
        this.out = out;
    }

    public void sendNotify(String message, String topic, String sender) {
        String notification = sender + " @ " + topic + ": " + message;
        out.println(notification);
    }

    public String getUsername() {
        return username;
    }
}

