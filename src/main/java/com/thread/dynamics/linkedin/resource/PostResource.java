package com.thread.dynamics.linkedin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;
import com.thread.dynamics.linkedin.dto.PostData;

@Path(ApplicationConstant.APP_VERSION)
public interface PostResource {

	@POST
	@Path("companies/{companyId}/shares")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response postFeed(@QueryParam("oauth2_access_token") String accessToken, @PathParam("companyId") String companyId,
			PostData postData, @QueryParam("format") String format);

}
