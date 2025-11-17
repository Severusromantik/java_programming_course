package Lab_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task_1 {
    public static void main(String[] args) {
        String fileName = "D:\\kpi_3course_1sem\\Мова_програмування_Java\\labs_code\\lab1_code\\java_lab1\\src\\Lab_5\\task_1.txt";

        String lineWithMaxWords = null;
        int maxWordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();

                if (trimmedLine.isEmpty()) {
                    continue;
                }

                String[] words = trimmedLine.split("\\s+");
                int currentWordCount = words.length;

                if (currentWordCount > maxWordCount) {
                    maxWordCount = currentWordCount;
                    lineWithMaxWords = line;
                }
            }

        } catch (IOException e) {
            System.err.println("Помилка під час читання файлу: " + e.getMessage());
            return;
        }

        System.out.println("Обробка файлу завершена.");
        if (lineWithMaxWords != null) {
            System.out.println("---");
            System.out.println("Рядок із максимальною кількістю слів (" + maxWordCount + " слів):");
            System.out.println(lineWithMaxWords);
        } else {
            System.out.println("Файл був порожнім або не містив слів.");
        }
    }
}
