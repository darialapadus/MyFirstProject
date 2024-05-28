package lab12.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class MyUtilityClass {
    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null.");
        }
        System.out.println(collection);
    }

    public static <T, R> R aggregate(Collection<T> collection, R initialResult, BiFunction<R, T, R> accumulator) {
        if (collection == null || accumulator == null) {
            throw new IllegalArgumentException("Collection and accumulator cannot be null.");
        }
        R result = initialResult;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public static <T> List<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null.");
        }
        List<T> duplicatedList = new ArrayList<>();
        for (T element : collection) {
            duplicatedList.add(element);
            duplicatedList.add(element);
        }
        return duplicatedList;
    }

}

