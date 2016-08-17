package com.thread.dynamics.sn.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.sn.dto.AccessTokenResponse;
import com.thread.dynamics.sn.dto.ApplicationConstant;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.resource.LinkedinAuthResource;
import com.thread.dynamics.sn.service.LinkedinAuthService;
import com.thread.dynamics.sn.service.BaseService;
import com.thread.dynamics.sn.util.Utility;

/**
 * The Class AuthServiceImpl.
 */
public class LinkedinAuthServiceImpl extends BaseService<LinkedinAuthResource> implements LinkedinAuthService {

    /** The Constant RESPONSE_TYPE_CODE. */
    private static final String RESPONSE_TYPE_CODE = "code";

    /** The Constant OAUTH_TOKEN_REQUEST_GRANT_TYPE. */
    private static final String OAUTH_TOKEN_REQUEST_GRANT_TYPE = "authorization_code";

    /**
     * Instantiates a new auth service impl.
     */
    public LinkedinAuthServiceImpl(String clientId, String clientSecret) {
        super(LinkedinAuthResource.class);
        this.clientId = "753ipo4qx9ywdu";
        this.clientSecret = "6clM1r6TonpnTeU5";
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

    /*
     * (non-Javadoc)
     * 
     * @see com.thread.dynamics.linkedin.service.AuthService#obtainOauthAccessToken(java.lang.String, java.lang.String)
     */
    @Override
    public AccessTokenResponse obtainOauthAccessToken(final String authorizationCode, String redirectUri) throws ServiceException {
        final Response accessTokenResponse = resource.obtainOauthAccessToken(OAUTH_TOKEN_REQUEST_GRANT_TYPE, authorizationCode, redirectUri, clientId, clientSecret);
        return handleResponse(accessTokenResponse, AccessTokenResponse.class, ServiceException.class);
    }

}
