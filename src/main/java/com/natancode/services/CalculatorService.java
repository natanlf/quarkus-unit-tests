package com.natancode.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natancode.rest.ExtensionsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@ApplicationScoped
public class CalculatorService {

    @Inject
    @RestClient
    ExtensionsService extensionsService;
    @Inject
    ObjectMapper objectMapper;

    public Integer sum(Integer n1, Integer n2) throws Exception {
        checkIfValuesAreNull(n1, n2);
        return n1 + n2;
    }

    public Integer decrease(Integer n1, Integer n2) throws Exception {
        checkIfValuesAreNull(n1, n2);
        checkIsForbiddenNumber(n1, n2);
        return n1 - n2;
    }

    private static void checkIfValuesAreNull(Integer n1, Integer n2) throws Exception {
        if(n1 == null || n2 == null) {
            throw new Exception("The values cannot be null");
        }
    }

    private void checkIsForbiddenNumber(Integer n1, Integer n2) throws Exception {
        var forbiddenNumbers = getForbiddenNumbers();
        if(forbiddenNumbers.stream().anyMatch(e -> e.equals(n1) || e.equals(n2) )) {
            throw new Exception("The values cannot be forbidden");
        }
    }

    private Set<Integer> getForbiddenNumbers() throws JsonProcessingException {
        var response = extensionsService.getForbiddenNumbers();
        var forbiddenNumbers = response.getJsonArray("forbiddenNumbers");
        return objectMapper.readValue(forbiddenNumbers.toString(), new TypeReference<Set<Integer>>(){});
    }
}
