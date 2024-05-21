package lab11.task1;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadPower {

    public static void main(String[] args) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        int size = 10000;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        int chunkSize = (size + numberOfThreads - 1) / numberOfThreads;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, size);
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
            System.out.println(number + "^2=" + square);
        }
    }
}

