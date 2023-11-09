package com.natancode.dto;

public class Error {
    private int code;
    private String message;
    private String className;
    private String propertyName;

    public Error(int code, String message, String className, String propertyName) {
        this.code = code;
        this.message = message;
        this.className = className;
        this.propertyName = propertyName;
    }

}
