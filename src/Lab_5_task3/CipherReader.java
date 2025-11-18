package Lab_5_task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CipherReader extends FilterReader {
    private final int key;

    public CipherReader(Reader in, char keyChar) {
        super(in);
        this.key = keyChar;
    }

    @Override
    public int read() throws IOException {
        int readChar = super.read();

        if (readChar == -1) {
            return -1;
        }

        int decryptedChar = readChar - key;
        return decryptedChar;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int charsRead = super.read(cbuf, off, len);

        if (charsRead == -1) {
            return -1;
        }

        for (int i = off; i < off + charsRead; i++) {
            cbuf[i] = (char) (cbuf[i] - key);
        }

        return charsRead;
    }
}