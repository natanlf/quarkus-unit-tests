package com.natancode.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.vertx.core.json.JsonObject;

@Path("/forbidden-numbers")
@RegisterRestClient
public interface ExtensionsService {
    @GET
    JsonObject getForbiddenNumbers();
}
