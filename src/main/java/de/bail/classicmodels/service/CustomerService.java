package de.bail.classicmodels.service;

import de.bail.classicmodels.model.CustomerDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
public interface CustomerService {

    @GET
    @Path("/customer/{id}")
    CustomerDto getCustomerById(@PathParam("id") int id);

    @GET
    @Path("/customer")
    List<CustomerDto> getCustomers();

}
