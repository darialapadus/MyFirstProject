package lab11.task1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPower {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 10000).boxed().collect(Collectors.toList());
        numbers.parallelStream()
                .forEach(number -> {
                    int square = number * number;
                    System.out.println(number + "^2=" + square);
                });
    }
}

