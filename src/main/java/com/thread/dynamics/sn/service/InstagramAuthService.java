package com.thread.dynamics.sn.service;

import com.thread.dynamics.sn.dto.InstagramAccessTokenResponse;
import com.thread.dynamics.sn.exception.ServiceException;

public interface InstagramAuthService {
	
    String obtainAuthorizationCodeUrl(String redirectURI);
    
    InstagramAccessTokenResponse obtainOauthAccessToken(String authorizationCode, String redirectUri) throws ServiceException;



}
