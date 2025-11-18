package Lab_5_task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CipherWriter extends FilterWriter {
    private final int key;

    public CipherWriter(Writer out, char keyChar) {
        super(out);
        this.key = keyChar;
    }

    @Override
    public void write(int c) throws IOException {
        int encryptedChar = c + key;
        super.write(encryptedChar);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] encryptedBuf = new char[len];
        for (int i = 0; i < len; i++) {

            encryptedBuf[i] = (char) (cbuf[off + i] + key);
        }
        super.write(encryptedBuf, 0, len);
    }
}