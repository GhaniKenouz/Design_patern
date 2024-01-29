// PathValidator.java
package com.fges.todoapp.util;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathValidator {

    public static boolean isValidPath(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
