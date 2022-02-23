package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.CustomerDto;
import de.bail.classicmodels.service.CustomerService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class CustomerController implements Serializable {

    private List<CustomerDto> customers;

    @Inject
    @RestClient
    CustomerService customerService;

    @PostConstruct
    public void init() {
        customers = customerService.getCustomers();
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }
}
