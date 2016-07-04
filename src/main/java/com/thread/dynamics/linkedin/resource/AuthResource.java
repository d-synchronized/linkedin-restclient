package com.thread.dynamics.linkedin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The Interface AuthResource.
 */
@Path("oauth/v2")
public interface AuthResource {

    /**
     * Obtain authorization code url.
     *
     * @param clientId the client id
     * @param redirectUrl the redirect url
     * @param responseType the response type
     * @param state the state
     */
    @GET
    @Path("authorization")
    public Response obtainAuthorizationCodeUrl(@QueryParam("client_id") final String clientId, @QueryParam("redirect_uri") final String redirectUrl, @QueryParam("response_type") final String responseType,
        @QueryParam("state") final String state);

    /**
     * Obtain oauth access token.
     *
     * @param granType the gran type
     * @param authorizationCode the authorization code
     * @param redirectUrl the redirect url
     * @param clientId the client id
     * @param clientSecret the client secret
     */
    @POST
    @Path("accessToken")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response obtainOauthAccessToken(@QueryParam("grant_type") String grantType, @QueryParam("code") String authorizationCode, @QueryParam("redirect_uri") String redirectUrl, @QueryParam("client_id") String clientId,
        @QueryParam("client_secret") String clientSecret);

}
