package org.harukasan.seln.io.output;

import org.harukasan.seln.io.IOObject;

import java.io.IOException;

public interface OutputObject extends IOObject {
    void writeLine(String line) throws IOException;
}
