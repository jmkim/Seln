package org.harukasan.seln.io.input;

import org.harukasan.seln.io.IOObject;

import java.io.IOException;

public interface InputObject extends IOObject {
    String readLine() throws IOException;
}
