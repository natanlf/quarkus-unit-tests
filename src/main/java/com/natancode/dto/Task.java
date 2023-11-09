package com.natancode.dto;

import jakarta.validation.constraints.*;

public class Task {

    @Pattern(regexp = "^[0-9]*$")
    @Size(max = 20)
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be empty")
    private String id;

    @Pattern(regexp = "[\\w\\W\\s]*")
    @Size(min=5, max = 20)
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be empty")
    private String name;

    private StatusTask status;

    public Task(String id, String name, StatusTask status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
