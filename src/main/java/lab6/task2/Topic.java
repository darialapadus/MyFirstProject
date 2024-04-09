package lab6.task2;

import java.util.ArrayList;

public class Topic {
    private String topName;
    private ArrayList<User> subs;

    public Topic(String _topName){
        topName = _topName;
        subs = new ArrayList<User>();
    }

    public void addSub(User user){
        subs.add(user);
    }

    public void publish(String message, User sender){
        for(var el: subs){
            System.out.println(el.sendNotify(message, topName, sender.getUsername()));
        }
    }
}
