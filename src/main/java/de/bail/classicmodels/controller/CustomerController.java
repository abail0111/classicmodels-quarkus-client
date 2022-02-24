package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.CustomerDto;
import de.bail.classicmodels.service.CustomerService;
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
public class CustomerController extends Pagination implements Serializable {

    private List<CustomerDto> customers;

    @ConfigProperty(name = "classicmodels.customer.limit")
    protected int limit;

    @Inject
    @RestClient
    CustomerService customerService;

    @PostConstruct
    public void init() {
        setLimit(limit);
        fetchData();
    }

    @Override
    public void fetchData() {
        Response response = customerService.getCustomers(getPage() * getLimit(), getLimit());
        customers = response.readEntity(new GenericType<List<CustomerDto>>() {});
        setTotal(Integer.parseInt(response.getHeaderString("x-total-count")));
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }
}
