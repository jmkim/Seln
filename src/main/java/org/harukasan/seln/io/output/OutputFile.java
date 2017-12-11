package org.harukasan.seln.io.output;

import java.io.*;

public class OutputFile implements OutputObject {
    private final BufferedWriter writer;
    private boolean isClosed;

    protected OutputFile(FileWriter writer) {
        this.writer = new BufferedWriter(writer);
        this.isClosed = false;
    }

    public static OutputFile getInstance(String path) throws IOException {
        return new OutputFile(new FileWriter(path));
    }

    public static OutputFile getInstance(FileWriter writer) {
        return new OutputFile(writer);
    }

    @Override
    public void writeLine(String line) throws IOException {
        if (isClosed) {
            throw new IOException("Output file is closed.");
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