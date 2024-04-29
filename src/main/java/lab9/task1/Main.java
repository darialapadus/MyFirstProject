package lab9.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SortedListSet<Integer> set1 = new SortedListSet<>();
        set1.add(5);
        set1.add(2);
        set1.add(8);
        set1.add(3);
        set1.add(1);
        System.out.println("set1: " + set1);

        SortedListSet<String> set2 = new SortedListSet<>();
        set2.add("apple");
        set2.add("banana");
        set2.add("cherry");
        set2.add("date");
        set2.add("grape");
        System.out.println("set2: " + set2);

        System.out.println("Primul element din set1: " + set1.first());
        System.out.println("Ultimul element din set1: " + set1.last());
        System.out.println("Primul element din set2: " + set2.first());
        System.out.println("Ultimul element din set2: " + set2.last());

        SortedSet<Integer> headSet = set1.headSet(5);
        System.out.println("Set1 cu elementele aflate inainte de elementul dat (5): " + headSet);
        SortedSet<Integer> subset = set1.subSet(2, 5);
        System.out.println("Set1 cu elementele aflate Intre douA elemente date (de la 2 la 5): " + subset);
        SortedSet<String> tailSet = set2.tailSet("cherry");
        System.out.println("Set2 cu elemente aflate dupa de elementul dat (cherry): " + tailSet);
    }
}

