package com.thread.dynamics.linkedin;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.dto.profile.BasicProfileInfo;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.UserService;
import com.thread.dynamics.linkedin.service.impl.AuthServiceImpl;
import com.thread.dynamics.linkedin.service.impl.UserServiceImpl;

public class LinkedinTest {

    private AuthService getAuthService() {
        final AuthService authService = new AuthServiceImpl("YOUR_CLIENT_ID", "YOUR_CLIENT_SECRET");
        return authService;
    }

    private UserService getUserService() {
        return new UserServiceImpl();
    }

    private String obtainAuthorizationCodeUrl(final String redirectUri) {
        final String requestUrl = getAuthService().obtainAuthorizationCodeUrl(redirectUri);
        return requestUrl;
    }

    private void obtainOauthToken(final String authorizationCode, final String redirectUri) throws ServiceException {
        final AccessTokenResponse accessTokenResponse = getAuthService().obtainOauthAccessToken(authorizationCode, redirectUri);
        System.out.println(accessTokenResponse.getAccessToken());
    }

    private void getBasicProfileInfo(final String accessToken) {
        BasicProfileInfo basicProfileInfo = null;
        try {
            basicProfileInfo = getUserService().getUserProfileInfo(accessToken);
        } catch (ServiceException exception) {
            exception.printStackTrace();
        }
        System.out.println(basicProfileInfo.getFirstName());
    }

    public static void main(String[] args) {
        final String redirectUri = "http://localhost:8080/YOUR_EXAMPLE_CONTEXT/api/v1/linkedin/callback";
        final LinkedinTest linkedinTest = new LinkedinTest();

//         final String authorizationCodeUrl = linkedinTest.obtainAuthorizationCodeUrl(redirectUri);
//         System.out.println(authorizationCodeUrl);
//        try {
//            linkedinTest.obtainOauthToken("AQRHF_XqWUKfwjgxsWBdyuGbjd15oOGJGPUQk6GS6LE5dlh4XhMiYSPQX-0DBMZoAHRdR_V8Oa-baum5MiGq-XG7e3qbt1sDteUrA-_giMcEtTZ7gLY", redirectUri);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
        
        linkedinTest.getBasicProfileInfo("YOUR_ACCESS_TOKEN");
    }

}
