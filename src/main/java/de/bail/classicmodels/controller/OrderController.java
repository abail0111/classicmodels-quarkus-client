package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.OrderDto;
import de.bail.classicmodels.model.ProductDto;
import de.bail.classicmodels.service.OrderService;
import de.bail.classicmodels.service.ProductService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class OrderController implements Serializable {

    private List<OrderDto> orders;

    @Inject
    @RestClient
    OrderService orderService;

    @PostConstruct
    public void init() {
        orders = orderService.getOrders();
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
