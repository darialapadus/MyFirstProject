package lab7.task1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:/Users/daria/OneDrive/Desktop/PAO/MyFirstProject/src/main/java/lab7/task1/input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            BufferedReader brSkipFirstLine = new BufferedReader(new InputStreamReader(fis));
            brSkipFirstLine.readLine();

            String line = brSkipFirstLine.readLine();
            System.out.println(line);

            br.close();
            brSkipFirstLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

