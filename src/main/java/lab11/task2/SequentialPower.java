package lab11.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SequentialPower {

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 10000000};
        try (FileWriter writer = new FileWriter("timings.txt", true)) {
            for (int size : sizes) {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    numbers.add(i);
                }

                long startTime = System.currentTimeMillis();

                for (int number : numbers) {
                    int square = number * number;
                    // System.out.println(number + "^2=" + square);
                }

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                writer.write("Sequential for " + size + " elements: " + duration + "ms\n");
                writer.flush();
                System.out.println("Sequential for " + size + " elements: " + duration + "ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

