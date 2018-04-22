package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.StatisticsApiService;
import io.swagger.api.factories.StatisticsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Stat;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/statistics")


@io.swagger.annotations.Api(description = "the statistics API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class StatisticsApi  {
   private final StatisticsApiService delegate;

   public StatisticsApi(@Context ServletConfig servletContext) {
      StatisticsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("StatisticsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (StatisticsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }
      
      if (delegate == null) {
         delegate = StatisticsApiServiceFactory.getStatisticsApi();
      }
      
      if (delegate.getConfig()==null)
    	  delegate.setConfig(servletContext);
      
      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns last 60 seconds stats", notes = "Returns last 60 seconds stats", response = Stat.class, tags={ "Statistics", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Stat.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No Transactions in last 60 seconds", response = Void.class) })
    public Response getStatistics(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStatistics(securityContext);
    }
}
