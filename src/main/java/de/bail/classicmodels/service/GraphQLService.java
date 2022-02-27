package de.bail.classicmodels.service;

import de.bail.classicmodels.model.graphql.SearchResult;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.Response;
import io.smallrye.graphql.client.core.Document;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static io.smallrye.graphql.client.core.Argument.arg;
import static io.smallrye.graphql.client.core.Document.document;
import static io.smallrye.graphql.client.core.Field.field;
import static io.smallrye.graphql.client.core.Operation.operation;
import static io.smallrye.graphql.client.core.FragmentReference.fragmentRef;

@ApplicationScoped
public class GraphQLService {

    @Inject
    @GraphQLClient("classicmodels-api")
    DynamicGraphQLClient dynamicGraphQLClient;

    public <T> List<T> queryList(String queryName, Map<String, Object> variables, Class<T> aClass) {
        try {
            Response response = query(queryName, variables);
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
        return null;
    }

    public <T> T queryObject(String queryName, Map<String, Object> variables, Class<T> aClass) {
        try {
            return query(queryName, variables).getObject(aClass, queryName);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response query(String documentName, Map<String, Object> variables) throws ExecutionException, InterruptedException {
        String document = loadDocument(documentName);
        System.out.println(document);
        return dynamicGraphQLClient.executeSync(document, variables);
    }

    public Uni<Response> queryAsync(String documentName, Map<String, Object> variables) {
        return dynamicGraphQLClient.executeAsync(loadDocument(documentName), variables);
    }

    private String loadDocument(String queryName) {
        try {
            String uri = UriBuilder.fromUri("/graphql/" + queryName + ".graphql").build().toString();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(uri);
            if (inputStream == null) {
                throw new IllegalArgumentException("query not found! " + queryName);
            } else {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<SearchResult> searchContact(String term, int limit) throws Exception {
//        Document query = document(
//                fragment("contact").on("Contact",
//                        field("firstName"),
//                        field("lastName")
//                ),
//                operation(
//                        field("searchContact", args(arg("term", term), arg("limit", limit)),
//                                fragmentRef("contact"),
//                                on("Customer", field("customerName"))
//                                // fragment or field?
//                        )
//                )
//        );
//        Response response = dynamicGraphQLClient.executeSync(query);
//        return response.getList(SearchResult.class, "searchContact");
//    }

}
