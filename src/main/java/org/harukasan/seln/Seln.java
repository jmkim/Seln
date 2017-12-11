package org.harukasan.seln;

import org.harukasan.seln.io.input.InputObject;
import org.harukasan.seln.io.output.OutputObject;

import java.io.*;

public final class Seln {
    private final InputObject input;
    private final OutputObject output;

    private Seln(InputObject input, OutputObject output) {
        this.input = input;
        this.output = output;
    }

    public static Seln getInstance(InputObject input, OutputObject output) {
        return new Seln(input, output);
    }

    public Seln extractByRatio(Double samplingRate) throws IOException {
        if (input.isClosed() || output.isClosed()) {
            return this;
        }

        Integer inputLineCount = 0, outputLineCount = 0;

        String buffer;
        while ((buffer = input.readLine()) != null) {
            ++inputLineCount;

            /* TODO: Apply randomising */
            if (outputLineCount <= inputLineCount * samplingRate) {
                output.writeLine(buffer);
                ++outputLineCount;
            }
        }

        return this;
    }

    public void close() throws IOException {
        /* TODO: Why don't we think about handling the IOException instead of rethrow it? */

        if (!input.isClosed()) {
            input.close();
        }

        if (!output.isClosed()) {
            output.close();
        }
    }
}
