package lab11.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadPower {

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 10000000};
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        try (FileWriter writer = new FileWriter("timings.txt", true)) {
            for (int size : sizes) {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    numbers.add(i);
                }

                int chunkSize = (size + numberOfThreads - 1) / numberOfThreads;
                List<Thread> threads = new ArrayList<>();

                long startTime = System.currentTimeMillis();

                for (int i = 0; i < numberOfThreads; i++) {
                    int start = i * chunkSize;
                    int end = Math.min(start + chunkSize, size);
                    if (start >= end) break;
                    Thread thread = new Thread(new PowerCalculator(numbers.subList(start, end)));
                    threads.add(thread);
                    thread.start();
                }

                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                writer.write("Thread for " + size + " elements: " + duration + "ms\n");
                writer.flush();
                System.out.println("Thread for " + size + " elements: " + duration + "ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PowerCalculator implements Runnable {
    private final List<Integer> numbers;

    PowerCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            int square = number * number;
            // System.out.println(number + "^2=" + square);
        }
    }
}
