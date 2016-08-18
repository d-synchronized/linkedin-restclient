package com.thread.dynamics.sn.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("oauth")
public interface InstagramAuthResource {

	@GET
	@Path("authorize")
	public Response obtainAuthorizationCodeUrl(@QueryParam("client_id") final String clientId,
			@QueryParam("redirect_uri") final String redirectUrl,
			@QueryParam("response_type") final String responseType,
			@QueryParam("response_type") final String responsetype);

	@POST
	@Path("access_token")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response obtainOauthAccessToken(@FormParam("grant_type") String grantType,
			@FormParam("code") String authorizationCode, @FormParam("redirect_uri") String redirectUrl,
			@FormParam("client_id") String clientId, @FormParam("client_secret") String clientSecret);

}
