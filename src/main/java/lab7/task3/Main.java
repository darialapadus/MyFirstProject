package lab7.task3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 1; i <= 10; i++) {
            String fileName = "fisier_" + i + ".txt";
            String content = "Index: " + i + "\nData si ora: " + LocalDateTime.now().format(formatter) + "\n";

            try {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(content);
                fileWriter.close();
                System.out.println("Fisierul \"" + fileName + "\" a fost creat cu succes.");
            } catch (IOException e) {
                System.out.println("A aparut o eroare la crearea fisierului \"" + fileName + "\":");
                e.printStackTrace();
            }
        }
    }
}

