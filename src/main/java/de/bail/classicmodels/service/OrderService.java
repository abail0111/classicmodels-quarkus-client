package de.bail.classicmodels.service;

import de.bail.classicmodels.model.OrderDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
public interface OrderService {

    @GET
    @Path("/order/{id}")
    OrderDto getOrderById(@PathParam("id") int id);

    @GET
    @Path("/order")
    List<OrderDto> getOrders();

}
