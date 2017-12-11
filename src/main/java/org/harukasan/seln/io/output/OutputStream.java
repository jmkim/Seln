package org.harukasan.seln.io.output;

import java.io.*;

public class OutputStream implements OutputObject {
    private final BufferedWriter writer;
    private boolean isClosed;

    protected OutputStream(OutputStreamWriter writer) {
        this.writer = new BufferedWriter(writer);
        this.isClosed = false;
    }

    public static OutputStream getInstance(java.io.OutputStream stream) throws IOException {
        return new OutputStream(new OutputStreamWriter(stream));
    }

    public static OutputStream getInstance(OutputStreamWriter writer) {
        return new OutputStream(writer);
    }

    @Override
    public void writeLine(String line) throws IOException {
        if (isClosed) {
            throw new IOException("Output stream is closed.");
        }

        writer.write(line);
        writer.newLine();
    }

    @Override
    public void close() throws IOException {
        writer.close();
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}