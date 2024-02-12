package com.fges.todoapp.files;

import java.util.HashMap;
import java.util.Map;

public class FileHandlerRegistry {
    private Map<String, FileHandlerFactory> registry = new HashMap<>();

    public void registerFileFactory(String extension, FileHandlerFactory factory) {
        if (extension == null || factory == null) {
            throw new IllegalArgumentException("Extension or factory cannot be null");
        }
        registry.put(extension.toLowerCase(), factory);
    }

    public FileHandlerFactory getFileHandlerFactory(String extension) {
        if (extension == null) {
            throw new IllegalArgumentException("Extension cannot be null");
        }
        return registry.get(extension.toLowerCase());
    }

    public boolean hasFileHandler(String extension) {
        if (extension == null) {
            throw new IllegalArgumentException("Extension cannot be null");
        }
        return registry.containsKey(extension.toLowerCase());
    }

    public void unregisterFileHandler(String extension) {
        if (extension == null) {
            throw new IllegalArgumentException("Extension cannot be null");
        }
        registry.remove(extension.toLowerCase());
    }
}
