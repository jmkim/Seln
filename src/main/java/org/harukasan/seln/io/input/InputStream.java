package org.harukasan.seln.io.input;

import java.io.*;

public class InputStream implements InputObject {
    private final BufferedReader reader;
    private boolean isClosed;

    protected InputStream(InputStreamReader reader) {
        this.reader = new BufferedReader(reader);
        this.isClosed = false;
    }

    public static InputStream getInstance(java.io.InputStream stream) {
        return new InputStream(new InputStreamReader(stream));
    }

    public static InputStream getInstance(InputStreamReader reader) {
        return new InputStream(reader);
    }

    @Override
    public String readLine() throws IOException {
        if (isClosed) {
            throw new IOException("Input stream is closed.");
        }

        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        reader.close();
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
