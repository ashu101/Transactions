package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Stat;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.servlet.ServletConfig;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-15T13:40:18.845Z")
public abstract class StatisticsApiService {
    private ServletConfig config;
	
	protected void setConfig(ServletConfig conn){
		config=conn;
	}
	protected ServletConfig getConfig(){
		return config;
	}
    public abstract Response getStatistics(SecurityContext securityContext) throws NotFoundException;
}
