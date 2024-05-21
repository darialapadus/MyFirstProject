package lab11.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPower {

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 10000000};
        try (FileWriter writer = new FileWriter("timings.txt", true)) {
            for (int size : sizes) {
                List<Integer> numbers = IntStream.range(0, size).boxed().collect(Collectors.toList());

                long startTime = System.currentTimeMillis();

                numbers.parallelStream()
                        .forEach(number -> {
                            int square = number * number;
                            // System.out.println(number + "^2=" + square);
                        });

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                writer.write("ParallelStream for " + size + " elements: " + duration + "ms\n");
                writer.flush();
                System.out.println("ParallelStream for " + size + " elements: " + duration + "ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

