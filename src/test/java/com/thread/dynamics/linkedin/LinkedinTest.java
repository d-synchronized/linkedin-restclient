package com.thread.dynamics.linkedin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.dto.companies.CompanyInfo;
import com.thread.dynamics.linkedin.dto.companies.CompanyPage;
import com.thread.dynamics.linkedin.dto.profile.BasicProfileInfo;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.resource.FeedResource;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.FeedService;
import com.thread.dynamics.linkedin.service.UserService;
import com.thread.dynamics.linkedin.service.impl.AuthServiceImpl;
import com.thread.dynamics.linkedin.service.impl.FeedServiceImpl;
import com.thread.dynamics.linkedin.service.impl.UserServiceImpl;

public class LinkedinTest {

    private AuthService getAuthService() {
        final AuthService authService = new AuthServiceImpl("YOUR_CLIENT_ID", "YOUR_CLIENT_SECRET");
        return authService;
    }

    private UserService getUserService() {
        return new UserServiceImpl();
    }
    
    private FeedService getFeedService() {
        return new FeedServiceImpl();
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
        
//        linkedinTest.getBasicProfileInfo("YOUR_ACCESS_TOKEN");
        

        String[] types={"type1","type2","type3"}; 
        
        linkedinTest.getCompaniesList("accessToken","query",types);
    }

	private void getCompaniesList(String accessToken, String query, String[] types) {

		StringBuilder typeString = new StringBuilder();
		for (String type : types) {
			typeString.append(type);
			typeString.append(",");
			typeString.deleteCharAt(types.length - 1);
		}

		CompanyPage companyPage = null;
		try {
			companyPage = getFeedService().fetchCompaniesList(accessToken, query, typeString.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
