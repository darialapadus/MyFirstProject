package lab5.task2;

public class Main {
    public static void main(String[] args) {
        MultiMapValue<String, Integer> multiMap = new MultiMapValue<>();

        multiMap.add("key1", 1);
        multiMap.add("key1", 2);
        multiMap.add("key2", 3);
        multiMap.add("key2", 4);

        System.out.println(multiMap.getValues("key1"));
        System.out.println(multiMap.getValues("key2"));

        System.out.println(multiMap.getFirst("key1"));
        System.out.println(multiMap.getFirst("key2"));

        System.out.println(multiMap.containsKey("key1"));
        System.out.println(multiMap.containsKey("key3"));

        System.out.println(multiMap.isEmpty());

        System.out.println(multiMap.size());

        multiMap.remove("key1");
        System.out.println(multiMap.getValues("key1"));
        System.out.println(multiMap.containsKey("key1"));
    }
}

