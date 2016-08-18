package com.thread.dynamics.sn.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.sn.dto.ApplicationConstant;
import com.thread.dynamics.sn.dto.InstagramAccessTokenResponse;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.resource.InstagramAuthResource;
import com.thread.dynamics.sn.service.BaseService;
import com.thread.dynamics.sn.service.InstagramAuthService;

public class InstagramAuthServiceImpl extends BaseService<InstagramAuthResource> implements InstagramAuthService {

	private static final String RESPONSE_TYPE_CODE = "code";
	private static final String OAUTH_TOKEN_REQUEST_GRANT_TYPE = "authorization_code";

	public InstagramAuthServiceImpl(String clientId, String clientSecret) {
		super(InstagramAuthResource.class);
		this.clientId = clientId;
		this.clientSecret = clientSecret;

	}

	@Override
	public String obtainAuthorizationCodeUrl(final String redirectURI) {
		String baseUrl = ApplicationConstant.INSTAGRAM_SERVER_URI + ApplicationConstant.INSTAGRAM_OAUTH_URL
				+ "/authorize";
		String finalUrl = baseUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectURI + "&response_type="
				+ RESPONSE_TYPE_CODE;
		return finalUrl;
	}

	@Override
	public InstagramAccessTokenResponse obtainOauthAccessToken(String authorizationCode, String redirectUri)
			throws ServiceException {

		final Response accessTokenResponse = resource.obtainOauthAccessToken(OAUTH_TOKEN_REQUEST_GRANT_TYPE,
				authorizationCode, redirectUri, clientId, clientSecret);
		return handleResponse(accessTokenResponse, InstagramAccessTokenResponse.class, ServiceException.class);

	}
}
