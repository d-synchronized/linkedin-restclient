package com.thread.dynamics.linkedin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;

@Path(ApplicationConstant.APP_VERSION)
public interface UserResource {

    /**
     * Gets the basic user profile.
     *
     * @param accessToken the access token
     * @return the basic user profile
     */
    @GET
    @Path("people/~")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response fetchBasicUserProfile(@QueryParam("oauth2_access_token") String accessToken, @QueryParam("format") String format);

}
