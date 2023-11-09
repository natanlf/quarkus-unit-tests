package com.natancode.dto;

import java.util.List;

public class CustomException extends Throwable {
    private List<Error> errors;

    public CustomException(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "errors=" + errors +
                '}';
    }
}
