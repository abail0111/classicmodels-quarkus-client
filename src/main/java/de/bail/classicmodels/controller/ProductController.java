package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.ProductDto;
import de.bail.classicmodels.model.ProductLineDto;
import de.bail.classicmodels.service.ProductLineService;
import de.bail.classicmodels.service.ProductService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class ProductController implements Serializable {

    private List<ProductDto> products;

    private List<ProductLineDto> productLines;

    @Inject
    @RestClient
    ProductService productService;

    @Inject
    @RestClient
    ProductLineService productLineService;

    @PostConstruct
    public void init() {
        products = productService.getProducts();
        productLines = productLineService.getProductLines();
    }

    public String setProductLine(String id) {

        return "products.xhtml?faces-redirect=true";
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductLineDto> getProductLines() {
        return productLines;
    }

    public void setProductLines(List<ProductLineDto> productLines) {
        this.productLines = productLines;
    }
}
