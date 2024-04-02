package lab5.bonus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.addValue(5);
        tree.addValue(3);
        tree.addValue(6);

        List<Integer> valuesToAdd = List.of(1, 4, 7, 10);
        tree.addAll(valuesToAdd);

        System.out.println(tree.getValues(3, 7));
        System.out.println(tree.size());
        System.out.println(tree.isEmpty());
    }
}
