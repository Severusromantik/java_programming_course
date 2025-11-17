package Lab_5_task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CipherWriter extends FilterWriter {
    private final int key;

    public CipherWriter(Writer out, char keyChar) {
        super(out);
        this.key = keyChar; // Код ключа, який будемо додавати
    }

    // Перехоплюємо метод запису одного символу
    @Override
    public void write(int c) throws IOException {
        int encryptedChar = c + key; // Шифрування: C_новий = C_текст + C_ключ
        super.write(encryptedChar); // Записуємо зашифрований символ у базовий потік
    }

    // Перехоплюємо метод запису масиву символів
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] encryptedBuf = new char[len];
        for (int i = 0; i < len; i++) {
            // Застосовуємо шифрування до кожного символу
            encryptedBuf[i] = (char) (cbuf[off + i] + key);
        }
        // Записуємо зашифрований масив у базовий потік
        super.write(encryptedBuf, 0, len);
    }
}