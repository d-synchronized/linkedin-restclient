package com.thread.dynamics.linkedin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Query;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;

@Path(ApplicationConstant.APP_VERSION)
public interface FeedResource {

	
	  	@GET
	    @Path("companies")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    Response fetchCompaniesList(@QueryParam("access_token") String accessToken, @QueryParam("query") String query,@QueryParam("types") String types);
}
