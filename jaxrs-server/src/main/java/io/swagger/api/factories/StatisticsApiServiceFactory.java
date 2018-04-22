package io.swagger.api.factories;

import io.swagger.api.StatisticsApiService;
import io.swagger.api.impl.StatisticsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class StatisticsApiServiceFactory {
    private final static StatisticsApiService service = new StatisticsApiServiceImpl();

    public static StatisticsApiService getStatisticsApi() {
        return service;
    }
}
