package com.natancode.resources;

import com.natancode.rest.ExtensionsService;
import com.natancode.services.CalculatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/calculator")
public class CalculatorResource {
    @Inject
    CalculatorService calculatorService;

    @GET
    @Path("/sum")
    @Produces(MediaType.TEXT_PLAIN)
    public String sum() throws Exception {
        return calculatorService.sum(1,1).toString();
    }

    @GET
    @Path("/decrease")
    @Produces(MediaType.TEXT_PLAIN)
    public String decrease() throws Exception {
        return calculatorService.decrease(1,1).toString();
    }
}
