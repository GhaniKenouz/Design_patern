// FileReader.java
package com.fges.todoapp.util;

import java.io.IOException;

public interface FileReader {
    String readFileContent(String fileName) throws IOException;
}
