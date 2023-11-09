package com.natancode.util;

import com.natancode.dto.CustomException;
import com.natancode.dto.Error;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.Set;

public class ValidationFields {

    public static void ValidateFiels(Object object, Validator validator) throws CustomException {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if(!violations.isEmpty()) {
            var errors = new ArrayList< Error >();
            violations.forEach(error -> {
                errors.add( new Error(500, error.getMessage(),
                        object.getClass().getName(), error.getPropertyPath().toString()) );
            });
            throw new CustomException(errors);
        }
    }
}
