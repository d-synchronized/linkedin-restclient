package com.thread.dynamics.linkedin.service.impl;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.dto.ApplicationConstant;
import com.thread.dynamics.linkedin.resource.AuthResource;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.BaseService;
import com.thread.dynamics.linkedin.util.Utility;

/**
 * The Class AuthServiceImpl.
 */
public class AuthServiceImpl extends BaseService<AuthResource> implements AuthService {

    private static final String RESPONSE_TYPE_CODE = "code";

    private static final String OAUTH_TOKEN_REQUEST_GRANT_TYPE = "authorization_code";

    /**
     * Instantiates a new auth service impl.
     */
    public AuthServiceImpl(String clientId, String clientSecret) {
        super(AuthResource.class);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.thread.dynamics.linkedin.service.AuthService#obtainAuthorizationCodeUrl(java.lang.String, java.lang.String)
     */
    @Override
    public String obtainAuthorizationCodeUrl(final String redirectURI) {
        String baseUrl = ApplicationConstant.SERVER_URI + ApplicationConstant.OAUTH_URL + "/authorization";
        String finalUrl = baseUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectURI + "&response_type=" + RESPONSE_TYPE_CODE + "&state=" + Utility.generateRandomNumber();
        return finalUrl;
    }
    

    @Override
    public AccessTokenResponse obtainOauthAccessToken(final String authorizationCode, String redirectUri) {
        final AccessTokenResponse accessTokenResponse = resource.obtainOauthAccessToken(OAUTH_TOKEN_REQUEST_GRANT_TYPE, authorizationCode, redirectUri, clientId, clientSecret);
        return accessTokenResponse;
    }

}
