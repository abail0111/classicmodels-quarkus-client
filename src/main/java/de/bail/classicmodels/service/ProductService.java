package de.bail.classicmodels.service;

import de.bail.classicmodels.model.ProductDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
public interface ProductService {

    @GET
    @Path("/product/{id}")
    ProductDto getProductById(@PathParam("id") int id);

    @GET
    @Path("/product")
    List<ProductDto> getProducts();

}
