package com.thread.dynamics.linkedin;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.impl.AuthServiceImpl;

public class LinkedinTest {

    private AuthService getAuthService() {
        final AuthService authService = new AuthServiceImpl("CLIENT_ID", "CLIENT_SECRET");
        return authService;
    }

    private String obtainAuthorizationCodeUrl(final String redirectUri) {
        final String requestUrl = getAuthService().obtainAuthorizationCodeUrl(redirectUri);
        return requestUrl;
    }

    private void obtainOauthToken(final String authorizationCode, final String redirectUri) {
        final AccessTokenResponse accessTokenResponse = getAuthService().obtainOauthAccessToken(authorizationCode, redirectUri);
        System.out.println(accessTokenResponse.getAccessToken());
    }

    public static void main(String[] args) {
        final String redirectUri = "http://localhost:8080/example/api/v1/linkedin/callback";
        final LinkedinTest linkedinTest = new LinkedinTest();

        // final String authorizationCodeUrl = linkedinTest.obtainAuthorizationCodeUrl(redirectUri);
        // System.out.println(authorizationCodeUrl);
        linkedinTest.obtainOauthToken("AQTRdq49AXwipnYESDUQN3NQNd8A21FR-_FCO6tJCeWQtuOF0fQrCqgo-2H5ZYgFoWZskhyL8zxrufG7VR22NIaUh0GNFvdmzAuFIvFQ89H2cStK8o0", redirectUri);
    }

}
