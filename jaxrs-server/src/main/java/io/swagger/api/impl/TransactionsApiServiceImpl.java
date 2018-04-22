package io.swagger.api.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import de.asheesh.constants.StringConstants;
import de.asheesh.element.TransactionEvent;
import de.asheesh.element.utils.EventUtils;
import de.asheesh.exceptions.TransactionException;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.TransactionsApiService;
import io.swagger.model.Transaction;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class TransactionsApiServiceImpl extends TransactionsApiService {
    @Override
    public Response addTransaction(Transaction body, SecurityContext securityContext) throws NotFoundException {
    	try{
			EventUtils.addTransaction((Map<Long,List<TransactionEvent>>) super.getConfig().getServletContext().getAttribute(StringConstants.CACHE_ATTRIBUTE),body);
    		if(body.getTimestamp() < System.currentTimeMillis()-Integer.valueOf(StringConstants.WINDOW))
        		return Response.status(204).entity(new ApiResponseMessage(ApiResponseMessage.INFO,StringConstants.OLD_TRANSACTION)).build();
        	else
        		return Response.status(201).entity(new ApiResponseMessage(ApiResponseMessage.OK, StringConstants.ADD_TRANSACTION_SUCCESS)).build();
    	}
    	catch(TransactionException e){
    		return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR,StringConstants.ADD_TRANSACTION_FAILURE+e)).build();
    	}
    }
}
