package io.swagger.api.factories;

import io.swagger.api.TransactionsApiService;
import io.swagger.api.impl.TransactionsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class TransactionsApiServiceFactory {
    private final static TransactionsApiService service = new TransactionsApiServiceImpl();

    public static TransactionsApiService getTransactionsApi() {
        return service;
    }
}
