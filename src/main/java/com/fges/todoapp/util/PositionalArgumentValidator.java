// PositionalArgumentValidator.java
package com.fges.todoapp.util;

public class PositionalArgumentValidator implements ArgumentValidator {

    @Override
    public boolean validateArguments(String[] args) {
        return args.length >= 3;
    }
}
