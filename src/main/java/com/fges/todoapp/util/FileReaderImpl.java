// FileReaderImpl.java
package com.fges.todoapp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderImpl implements FileReader {
    @Override
    public String readFileContent(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);

        if (Files.exists(filePath)) {
            return Files.readString(filePath);
        }

        return "";
    }
}
