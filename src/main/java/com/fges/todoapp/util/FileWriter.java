// FileWriter.java
package com.fges.todoapp.util;

import java.io.IOException;

public interface FileWriter {
    void writeToFile(String fileName, String content) throws IOException;
}
