package de.bail.classicmodels.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
public interface CustomerService {

    @GET
    @Path("/customer/{id}")
    Response getCustomerById(@PathParam("id") int id);

    @GET
    @Path("/customer")
    Response getCustomers(@QueryParam("offset") int offset,
                          @QueryParam("limit") int limit);

}
