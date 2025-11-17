package Lab_5_task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainApp {
    private static final char KEY = 'K'; // Ключовий символ шифрування

    /**
     * Реалізує шифрування файлу за допомогою CipherWriter.
     */
    public static void encryptFile(String inputFile, String outputFile) throws IOException {
        // Читаємо оригінальний файл, записуємо у зашифрований файл через CipherWriter
        try (FileReader fileIn = new FileReader(inputFile);
             FileWriter fileOut = new FileWriter(outputFile);
             CipherWriter cipherOut = new CipherWriter(fileOut, KEY))
        {
            int c;
            // Читання з FileReader та запис у CipherWriter (де відбувається шифрування)
            while ((c = fileIn.read()) != -1) {
                cipherOut.write(c);
            }
            System.out.println("✅ Файл '" + inputFile + "' успішно зашифровано у '" + outputFile + "'.");
        }
    }

    /**
     * Реалізує дешифрування файлу за допомогою CipherReader.
     */
    public static void decryptFile(String inputFile, String outputFile) throws IOException {
        // Читаємо зашифрований файл через CipherReader, записуємо у розшифрований файл
        try (FileReader fileIn = new FileReader(inputFile);
             CipherReader cipherIn = new CipherReader(fileIn, KEY);
             FileWriter fileOut = new FileWriter(outputFile))
        {
            int c;
            // Читання з CipherReader (де відбувається дешифрування) та запис у FileWriter
            while ((c = cipherIn.read()) != -1) {
                fileOut.write(c);
            }
            System.out.println("✅ Файл '" + inputFile + "' успішно дешифровано у '" + outputFile + "'.");
        }
    }

    public static void main(String[] args) {
        String originalFile = "src/Lab_5_task3/original.txt";
        String encryptedFile = "src/Lab_5_task3/encrypted.txt";
        String decryptedFile = "src/Lab_5_task3/decrypted.txt";

        // 1. Створення тестового файлу
        try (FileWriter writer = new FileWriter(originalFile)) {
            writer.write("Перевірка роботи шифру для завдання 3.");
            System.out.println("ℹ️ Створено оригінальний файл: " + originalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // 2. Шифрування
            encryptFile(originalFile, encryptedFile);

            // 3. Дешифрування
            decryptFile(encryptedFile, decryptedFile);

            System.out.println("\n--- Результати ---");
            System.out.println("Перевірте вміст файлів:");
            System.out.println("1. " + originalFile + " (Оригінал)");
            System.out.println("2. " + encryptedFile + " (Зашифровано)");
            System.out.println("3. " + decryptedFile + " (Розшифровано - має співпадати з оригіналом)");

        } catch (IOException e) {
            System.err.println("❌ Помилка I/O: " + e.getMessage());
        }
    }
}