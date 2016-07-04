package com.thread.dynamics.linkedin.service;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.exception.ServiceException;

/**
 * The Interface AuthService.
 */
public interface AuthService {

    /**
     * Obtain authorization code url.
     *
     * @param clientId the client id
     * @param redirectURI the redirect uri
     * @return the string
     */
    String obtainAuthorizationCodeUrl(String redirectURI);

    /**
     * Obtain oauth access token.
     *
     * @param authorizationCode the authorization code
     * @param redirectUri the redirect uri
     * @return the access token response
     * @throws ServiceException 
     */
    AccessTokenResponse obtainOauthAccessToken(String authorizationCode, String redirectUri) throws ServiceException;

}
