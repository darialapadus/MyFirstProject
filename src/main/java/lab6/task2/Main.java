package lab6.task2;

public class Main {
    public static void main(String[] args) {

        User adrian = new User("Adrian");
        User ion = new User("Ion");
        User maria = new User("Maria");
        User matei = new User("Matei");

        Topic gatit = new Topic("gatit");
        Topic programare = new Topic("programare");

        programare.addSub(adrian);
        programare.addSub(ion);
        programare.addSub(matei);
        gatit.addSub(maria);


        gatit.publish("Omlette du fromage", adrian);
        programare.publish("Salutare!", ion);
    }
}

