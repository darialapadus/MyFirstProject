package lab5.task1;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent());
        System.out.println(o1.get());

        MyOptional<Object> o2 = MyOptional.of(List.of("1", "2"));
        System.out.println(o2.isPresent());
        System.out.println(o2.get());

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent());
        try {
            System.out.println(o3.get());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException caught");
        }

        // MyOptional<Integer> o4 = MyOptional.of("3");
    }
}
