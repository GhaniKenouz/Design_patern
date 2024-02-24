
package com.fges.todoapp.files;

import java.util.HashMap;
import java.util.Map;

public class FileHandlerRegistry {
    private final Map<String, FileHandlerFactory> registry = new HashMap<>();

    public void registerFileF (String extension, FileHandler fileHandler) {
        registry.put(extension, fileHandler);
    }
        public FileHandler getFileHandler(String extension) {
            return registry.get(extension);
        }

    }