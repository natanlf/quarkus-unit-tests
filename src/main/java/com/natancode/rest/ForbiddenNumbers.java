package com.natancode.rest;

import java.util.Set;

public class ForbiddenNumbers {
    private Set<Integer> forbiddenNumbers;

    public ForbiddenNumbers(Set<Integer> forbiddenNumbers) {
        this.forbiddenNumbers = forbiddenNumbers;
    }

    public Set<Integer> getForbiddenNumbers() {
        return forbiddenNumbers;
    }

    public void setForbiddenNumbers(Set<Integer> forbiddenNumbers) {
        this.forbiddenNumbers = forbiddenNumbers;
    }
}
