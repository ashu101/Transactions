package io.swagger.api.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import de.asheesh.constants.StringConstants;
import de.asheesh.element.TransactionEvent;
import de.asheesh.element.utils.EventUtils;
import io.swagger.api.NotFoundException;
import io.swagger.api.StatisticsApiService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public class StatisticsApiServiceImpl extends StatisticsApiService {
    @Override
    public Response getStatistics(SecurityContext securityContext) throws NotFoundException {
        return Response.status(200).entity(
        		EventUtils.getStats((Map<Long,List<TransactionEvent>>) super.getConfig().getServletContext().getAttribute(StringConstants.CACHE_ATTRIBUTE)))
        		.build();
    }
}
