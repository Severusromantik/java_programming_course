package Lab_3;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class BookFileHandler {

    public void saveBooks(Book[] books, String filename) throws IOException, InvalidPathException {
        validateFilename(filename);

        try (FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(books);
        }
    }

    public Book[] loadBooks(String filename) throws IOException, ClassNotFoundException, InvalidPathException {
        validateFilename(filename);

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            return (Book[]) objectIn.readObject();
        }
    }

    private void validateFilename(String filename) throws InvalidPathException {
        if (filename == null || filename.trim().isEmpty()) {
            throw new InvalidPathException(filename, "Ім'я файлу не може бути порожнім.");
        }
        try {
            Paths.get(filename);
        } catch (InvalidPathException e) {
            throw new InvalidPathException(filename, "Некоректний формат імені/шляху файлу.");
        }
    }
}