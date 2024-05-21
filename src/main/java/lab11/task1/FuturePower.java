package lab11.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FuturePower {

    public static void main(String[] args) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        int size = 10000;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        ExecutorService executor = Executors.newWorkStealingPool();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        int chunkSize = (size + numberOfThreads - 1) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, size);
            List<Integer> sublist = numbers.subList(start, end);

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (int number : sublist) {
                    int square = number * number;
                    System.out.println(number + "^2=" + square);
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

        executor.shutdown();
    }
}

