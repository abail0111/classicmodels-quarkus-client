package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.OrderDto;
import de.bail.classicmodels.service.OrderService;
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
public class OrderController extends Pagination implements Serializable {

    private List<OrderDto> orders;

    private String status;

    @ConfigProperty(name = "classicmodels.order.limit")
    protected int limit;

    @Inject
    @RestClient
    OrderService orderService;

    @PostConstruct
    public void init() {
        setLimit(limit);
        fetchData();
    }

    @Override
    public void fetchData() {
        Response response = orderService.getOrders(getPage() * getLimit(), getLimit(), status);
        orders = response.readEntity(new GenericType<List<OrderDto>>() {});
        setTotal(Integer.parseInt(response.getHeaderString("x-total-count")));
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
