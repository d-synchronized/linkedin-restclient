package com.thread.dynamics.sn;

import com.thread.dynamics.sn.dto.InstagramAccessTokenResponse;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.service.InstagramAuthService;
import com.thread.dynamics.sn.service.impl.InstagramAuthServiceImpl;

public class InstagramTest {

	private InstagramAuthService getInstagramAuthService() {
		final InstagramAuthService authService = new InstagramAuthServiceImpl("d3d6f31ad4134d9991616c43d9f7bfa5",
				"33bcdfe763d1438d9a1343672eb17c4a");
		return authService;
	}

	private String obtainAuthorizationCodeUrl(final String redirectUri) {
		final String requestUrl = getInstagramAuthService().obtainAuthorizationCodeUrl(redirectUri);
		return requestUrl;
	}

	private void obtainOauthToken(String authorizationCode, String redirectUri) throws ServiceException {
		
        final InstagramAccessTokenResponse accessTokenResponse = getInstagramAuthService().obtainOauthAccessToken(authorizationCode, redirectUri);
        System.out.println(accessTokenResponse.getAccessToken());

	}

	public static void main(String[] args) {
		final String redirectUri = "http://localhost:8080/boarding/api/v1/collection-center";

		final String authorizationCode = "201b9d77fca24b9baeb93aaedd738fe5";

		InstagramTest instagramTest = new InstagramTest();

		final String authorizationCodeUrl = instagramTest.obtainAuthorizationCodeUrl(redirectUri);
		System.out.println(authorizationCodeUrl);

		try {
			instagramTest.obtainOauthToken(authorizationCode, redirectUri);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
