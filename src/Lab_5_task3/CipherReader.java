package Lab_5_task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CipherReader extends FilterReader {
    private final int key;

    public CipherReader(Reader in, char keyChar) {
        super(in);
        this.key = keyChar; // Код ключа, використаний для шифрування
    }

    // Перехоплюємо метод читання одного символу
    @Override
    public int read() throws IOException {
        int readChar = super.read(); // Читаємо зашифрований символ

        if (readChar == -1) {
            return -1; // Кінець потоку
        }

        int decryptedChar = readChar - key; // Дешифрування: C_текст = C_новий - C_ключ
        return decryptedChar; // Повертаємо розшифрований символ
    }

    // Перехоплюємо метод читання масиву символів
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int charsRead = super.read(cbuf, off, len); // Читаємо зашифровані символи у буфер

        if (charsRead == -1) {
            return -1; // Кінець потоку
        }

        // Дешифруємо символи безпосередньо у буфері
        for (int i = off; i < off + charsRead; i++) {
            cbuf[i] = (char) (cbuf[i] - key);
        }

        return charsRead;
    }
}