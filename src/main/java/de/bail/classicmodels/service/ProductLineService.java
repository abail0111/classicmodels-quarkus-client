package de.bail.classicmodels.service;

import de.bail.classicmodels.model.ProductLineDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
public interface ProductLineService {

    @GET
    @Path("/productline")
    List<ProductLineDto> getProductLines();

}
