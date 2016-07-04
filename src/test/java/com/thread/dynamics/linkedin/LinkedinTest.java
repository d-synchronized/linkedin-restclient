package com.thread.dynamics.linkedin;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.impl.AuthServiceImpl;

/**
 * The Class LinkedinTest.
 */
public class LinkedinTest {

    /**
     * Gets the auth service.
     *
     * @return the auth service
     */
    private AuthService getAuthService() {
        final AuthService authService = new AuthServiceImpl("CLIENT_ID", "CLIENT_SECRET");
        return authService;
    }

    /**
     * Obtain authorization code url.
     *
     * @param redirectUri the redirect uri
     * @return the string
     */
    private String obtainAuthorizationCodeUrl(final String redirectUri) {
        final String requestUrl = getAuthService().obtainAuthorizationCodeUrl(redirectUri);
        return requestUrl;
    }

    /**
     * Obtain oauth token.
     *
     * @param authorizationCode the authorization code
     * @param redirectUri the redirect uri
     * @throws ServiceException the service exception
     */
    private void obtainOauthToken(final String authorizationCode, final String redirectUri) throws ServiceException {
        final AccessTokenResponse accessTokenResponse = getAuthService().obtainOauthAccessToken(authorizationCode, redirectUri);
        System.out.println(accessTokenResponse.getAccessToken());
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        final String redirectUri = "http://localhost:8080/example/api/v1/linkedin/callback";
        final LinkedinTest linkedinTest = new LinkedinTest();

        final String authorizationCodeUrl = linkedinTest.obtainAuthorizationCodeUrl(redirectUri);
        System.out.println(authorizationCodeUrl);
        // try {
        // linkedinTest.obtainOauthToken("AQRtGFFlhmGqFT-Bxxp7cfLSVtz-CCbzYY-0CMWCUfVlaLpjBEr_Efcg14fU266bELF9ClqfHaSIek2UzlyxPteZ75tbFDr7tyMPqOx2em9tZUq-BAc",
        // redirectUri);
        // } catch (ServiceException e) {
        // e.printStackTrace();
        // }
    }

}
