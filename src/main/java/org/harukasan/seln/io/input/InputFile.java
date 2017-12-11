package org.harukasan.seln.io.input;

import java.io.*;

public class InputFile implements InputObject {
    private final BufferedReader reader;
    private boolean isClosed;

    protected InputFile(FileReader reader) {
        this.reader = new BufferedReader(reader);
        this.isClosed = false;
    }

    public static InputFile getInstance(String path) throws FileNotFoundException {
        return new InputFile(new FileReader(path));
    }

    public static InputFile getInstance(FileReader reader) {
        return new InputFile(reader);
    }

    @Override
    public String readLine() throws IOException {
        if (isClosed) {
            throw new IOException("Input file is closed.");
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
