package Lab_5_task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    private static final char KEY = 'K';


    public static void encryptFile(String inputFile, String outputFile) throws IOException {
        try (FileReader fileIn = new FileReader(inputFile);
             FileWriter fileOut = new FileWriter(outputFile);
             CipherWriter cipherOut = new CipherWriter(fileOut, KEY))
        {
            int c;
            while ((c = fileIn.read()) != -1) {
                cipherOut.write(c);
            }
            System.out.println("Файл '" + inputFile + "' успішно зашифровано у '" + outputFile + "'.");
        }
    }

    public static void decryptFile(String inputFile, String outputFile) throws IOException {
        try (FileReader fileIn = new FileReader(inputFile);
             CipherReader cipherIn = new CipherReader(fileIn, KEY);
             FileWriter fileOut = new FileWriter(outputFile))
        {
            int c;
            while ((c = cipherIn.read()) != -1) {
                fileOut.write(c);
            }
            System.out.println("Файл '" + inputFile + "' успішно дешифровано у '" + outputFile + "'.");
        }
    }

    public static void main(String[] args) {
        String originalFile = "original.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=========================================");
            System.out.print("Введіть речення, яке ви хочете зашифрувати: ");
            String userInput = scanner.nextLine();
            System.out.println("=========================================");

            try (FileWriter writer = new FileWriter(originalFile)) {
                writer.write(userInput);
            } catch (IOException e) {
                System.err.println("Помилка запису в оригінальний файл: " + e.getMessage());
                return;
            }
        } catch (Exception e) {
            System.err.println("Помилка під час зчитування введення: " + e.getMessage());
            return;
        }


        try {
            encryptFile(originalFile, encryptedFile);

            decryptFile(encryptedFile, decryptedFile);

            System.out.println("\n--- Результати ---");
            System.out.println("Оригінальний текст успішно оброблено.");
            System.out.println("Файл із зашифрованим текстом: " + encryptedFile);
            System.out.println("Файл із розшифрованим текстом: " + decryptedFile + " (має співпадати з вашим введенням)");

        } catch (IOException e) {
            System.err.println("Помилка I/O під час шифрування/дешифрування: " + e.getMessage());
        }
    }
}