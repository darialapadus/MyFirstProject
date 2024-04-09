package lab6.task2;

public class User {
    private String username;
    public User(String _username){
        username = _username;
    }

    public String sendNotify(String message, String topic, String sender){
        return "[" + username + "] " + sender + " @ " + topic + ": " + message;
    }

    public String getUsername() {
        return username;
    }
}

