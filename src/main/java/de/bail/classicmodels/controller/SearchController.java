package de.bail.classicmodels.controller;

import de.bail.classicmodels.model.graphql.SearchResult;
import de.bail.classicmodels.service.GraphQLService;
import io.smallrye.graphql.client.Response;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ExecutionException;

@ViewScoped
@Named
public class SearchController implements Serializable {

    private String searchTerm;

    private int limit = 5;

    private List<SearchResult> contacts;

    @Inject
    GraphQLService graphQLService;

    @PostConstruct
    public void init() {
        contacts = new ArrayList<>();
    }

    public void search() {
        String queryName = "searchContact";
        Map<String, Object> variables  = new HashMap<>() {{
            put("term", searchTerm);
            put("limit", limit);
        }};
        contacts = fetchData("searchContact", variables, SearchResult.class);
    }

    private <T> List<T> fetchData(String queryName, Map<String, Object> variables, Class<T> aClass) {
        try {
            Response response = graphQLService.query(queryName, variables);
            System.out.println(response.getTransportMeta().toString());
            if (response.hasError()) {
                System.out.println(response.getErrors().toString());
            }
            if (response.hasData()) {
                System.out.println(response.getData().toString());
                return response.getList(aClass, queryName);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<SearchResult> getContacts() {
        return contacts;
    }

    public void setContacts(List<SearchResult> contacts) {
        this.contacts = contacts;
    }
}
