package com.natancode.dto;

import com.natancode.util.ValidationFields;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class TaskTest {

    @Inject
    Validator validator;

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource( strings = {"b", "111111111111111111111"})
    void shouldValidateTaskId(String id) {
        var task = new Task(id, "watch the course", StatusTask.BACKLOG);
        assertThrows(CustomException.class, () -> ValidationFields.ValidateFiels(task, validator) );
    }
}
