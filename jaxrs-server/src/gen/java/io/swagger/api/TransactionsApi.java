package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.TransactionsApiService;
import io.swagger.api.factories.TransactionsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Transaction;

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

@Path("/transactions")


@io.swagger.annotations.Api(description = "the transactions API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class TransactionsApi  {
   private final TransactionsApiService delegate;

   public TransactionsApi(@Context ServletConfig servletContext) {
      TransactionsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("TransactionsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (TransactionsApiService) Class.forName(implClass).newInstance();
               System.out.println("***********************************************");
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = TransactionsApiServiceFactory.getTransactionsApi();
      }

      if (delegate.getConfig()==null)
    	  delegate.setConfig(servletContext);
      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new transaction to the transactions", notes = "", response = Void.class, tags={ "Transactions", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Success", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "transaction is older than 60 seconds.", response = Void.class) })
    public Response addTransaction(@ApiParam(value = "holds amount and timestamp." ,required=true) Transaction body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addTransaction(body,securityContext);
    }
}
