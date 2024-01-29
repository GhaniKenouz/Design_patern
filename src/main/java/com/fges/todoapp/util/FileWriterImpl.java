// FileWriterImpl.java
package com.fges.todoapp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String fileName, String content) throws IOException {
        Files.writeString(Path.of(fileName), content);
    }
}
