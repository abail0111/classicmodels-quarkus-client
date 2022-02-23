package de.bail.classicmodels.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class SearchController implements Serializable {

    private String searchTerm;

    @PostConstruct
    public void init() {

    }

    public void search() {
        // TODO implement search here
    }


    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
