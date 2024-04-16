package lab7.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/daria/OneDrive/Desktop/PAO/MyFirstProject/src/main/java/lab7/task1/input.txt");
            Scanner scanner = new Scanner(file);

            scanner.nextLine();

            String line = scanner.nextLine();
            System.out.println(line);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
