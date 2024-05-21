package lab11.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FuturePower {

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 10000000};
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        try (FileWriter writer = new FileWriter("timings.txt", true)) {
            for (int size : sizes) {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    numbers.add(i);
                }

                ExecutorService executor = Executors.newWorkStealingPool();
                List<CompletableFuture<Void>> futures = new ArrayList<>();

                int chunkSize = (size + numberOfThreads - 1) / numberOfThreads;

                long startTime = System.currentTimeMillis();

                for (int i = 0; i < numberOfThreads; i++) {
                    int start = i * chunkSize;
                    int end = Math.min(start + chunkSize, size);
                    if (start >= end) break;
                    List<Integer> sublist = numbers.subList(start, end);

                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                        for (int number : sublist) {
                            int square = number * number;
                            // System.out.println(number + "^2=" + square);
                        }
                    }, executor);

                    futures.add(future);
                }

                futures.forEach(future -> {
                    try {
                        future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                writer.write("CompletableFuture for " + size + " elements: " + duration + "ms\n");
                writer.flush();
                System.out.println("CompletableFuture for " + size + " elements: " + duration + "ms");

                executor.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


