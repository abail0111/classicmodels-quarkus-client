package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.ProductDto;
import de.bail.classicmodels.model.ProductLineDto;
import de.bail.classicmodels.service.ProductLineService;
import de.bail.classicmodels.service.ProductService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class ProductController extends Pagination implements Serializable {

    private List<ProductDto> products;

    private List<ProductLineDto> productLines;

    private String selectedProductLine;

    @ConfigProperty(name = "classicmodels.product.limit")
    protected int limit;

    @Inject
    @RestClient
    ProductService productService;

    @Inject
    @RestClient
    ProductLineService productLineService;

    @PostConstruct
    public void init() {
        setLimit(limit);
        fetchData();
        productLines = productLineService.getProductLines();
    }

    @Override
    public void fetchData() {
        Response response = productService.getProducts(getPage() * getLimit(), getLimit(), selectedProductLine);
        products = response.readEntity(new GenericType<List<ProductDto>>() {});
        setTotal(Integer.parseInt(response.getHeaderString("x-total-count")));
    }

    public String setProductLine(String id) {
        // TODO filter logic
        //setPage(0);
        return "products.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDto productDto) {
        productService.deleteProductById(productDto.getId());
    }

    public void updateProduct(ProductDto productDto) {
        productService.updateProductById(productDto.getId(), productDto);
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
