package io.swagger.api;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import de.asheesh.constants.StringConstants;
import de.asheesh.element.TransactionEvent;
import de.asheesh.runnable.Cleaner;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;

public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title(StringConstants.SERVER)
      .description(StringConstants.SERVER_DESC)
      .termsOfService("")
      .contact(new Contact()
        .email(StringConstants.EMAIL))
      ;

    Map<Long,List<TransactionEvent>> cache = new ConcurrentHashMap<Long,List<TransactionEvent>>();
    ServletContext context = config.getServletContext();
    context.setAttribute(StringConstants.CACHE_ATTRIBUTE,cache);
    context.setAttribute(StringConstants.CACHE_CLEANER_ATTRIBUTE, 
    		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Cleaner(cache),Integer.valueOf(StringConstants.CACHE_CLEANER_LOAD_DELAY),Integer.valueOf(StringConstants.CACHE_CLEANER_FREQUENCY),TimeUnit.MINUTES));
    Swagger swagger = new Swagger().info(info);
    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
