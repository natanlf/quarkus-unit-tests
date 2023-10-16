package com.natancode;

import com.natancode.rest.ExtensionsService;
import com.natancode.services.CalculatorService;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.InjectMock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class CalculatorServiceTest {

    @Inject
    CalculatorService calculatorService;

    @InjectMock
    @RestClient
    ExtensionsService extensionsService;


    @Test
    public void shouldSum() throws Exception {
        //scenario
        Integer n1 = 10;
        Integer n2 = 10;

        //action
        var sumResponse = calculatorService.sum(n1, n2);

        //verification
        Assertions.assertEquals(20, sumResponse);
    }

    @Test
    public void shouldNotSum() {
        //scenario
        Integer n1 = null;
        Integer n2 = 10;

        //verification
        assertThrows(Exception.class, () -> calculatorService.sum(n1, n2));
    }

    @Test
    public void shouldDecrease() throws Exception {
        //scenario
        Integer n1 = 10;
        Integer n2 = 10;

        Mockito.when(extensionsService.getForbiddenNumbers())
                .thenReturn(new JsonObject("{\"forbiddenNumbers\":[5,7,23]}"));

        //action
        var decreaseResponse = calculatorService.decrease(n1, n2);

        //verification
        Assertions.assertEquals(0, decreaseResponse);
    }

    @Test
    public void shouldNotDecrease() {
        Integer n1 = 5;
        Integer n2 = 10;

        /*ExtensionsService customMock = new ExtensionsService() {
            @Override
            public JsonObject getForbiddenNumbers() {
                return new JsonObject("{\"forbiddenNumbers\":[5,7,23]}");
            }
        };
        QuarkusMock.installMockForType(customMock, ExtensionsService.class, RestClient.LITERAL);*/

        Mockito.when(extensionsService.getForbiddenNumbers()).thenReturn(new JsonObject("{\"forbiddenNumbers\":[5,7,23]}"));


        assertThrows(Exception.class, () -> calculatorService.decrease(n1, n2));
    }
}
