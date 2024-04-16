package lab7.task2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:/Users/daria/OneDrive/Desktop/PAO/MyFirstProject/src/main/java/lab7/task2/input.txt");
            Scanner scanner = new Scanner(fileReader);

            scanner.nextLine();

            String line = scanner.nextLine();
            System.out.println(line);

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

