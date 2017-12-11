package org.harukasan.seln.io;

import java.io.IOException;

public interface IOObject {
    void close() throws IOException;

    boolean isClosed();
}
