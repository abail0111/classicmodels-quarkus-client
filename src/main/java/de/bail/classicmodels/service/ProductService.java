package de.bail.classicmodels.service;

import de.bail.classicmodels.model.ProductDto;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "classicmodels-api")
@RegisterClientHeaders
public interface ProductService {

    @GET
    @Path("/product/{id}")
    Response getProductById(@PathParam("id") String id);

    @GET
    @Path("/product")
    Response getProducts(@QueryParam("offset") int offset,
                         @QueryParam("limit") int limit,
                         @QueryParam("productline") String productLine);

    @DELETE
    @Path("/product/{id}")
    void deleteProductById(@PathParam("id") String id);

    @PUT
    @Path("/product/{id}")
    void updateProductById(@PathParam("id") String id, @Valid ProductDto entity);

}
