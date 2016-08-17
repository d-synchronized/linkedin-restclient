package com.thread.dynamics.sn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thread.dynamics.sn.dto.AccessTokenResponse;
import com.thread.dynamics.sn.dto.companies.CompanyInfo;
import com.thread.dynamics.sn.dto.companies.CompanyPage;
import com.thread.dynamics.sn.dto.profile.BasicProfileInfo;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.resource.FeedResource;
import com.thread.dynamics.sn.service.AuthService;
import com.thread.dynamics.sn.service.FeedService;
import com.thread.dynamics.sn.service.UserService;
import com.thread.dynamics.sn.service.impl.AuthServiceImpl;
import com.thread.dynamics.sn.service.impl.FeedServiceImpl;
import com.thread.dynamics.sn.service.impl.UserServiceImpl;

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
//        final String redirectUri = "http://localhost:8080/mangle/api/v1/linkedin/callback";
        final LinkedinTest linkedinTest = new LinkedinTest();
//
//         final String authorizationCodeUrl = linkedinTest.obtainAuthorizationCodeUrl(redirectUri);
//         System.out.println(authorizationCodeUrl);
//        try {
//            linkedinTest.obtainOauthToken("AQRKWwwmy0WNYd_5yJROl_cL0RnUqQqmbll4pPspCvliZFy_N26utCMJzUXht9YcqRaAHY4aiLqn-g25C6CQHV58epnc4E0QGR_7GJZSzzbsx6BXF4U", redirectUri);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        
//        linkedinTest.getBasicProfileInfo("YOUR_ACCESS_TOKEN");
//        
//
//        String[] types={"type1","type2","type3"}; 
//        
//        linkedinTest.getCompaniesList("accessToken","query",types);
        
        linkedinTest.getCompanyUpdates("companyId","accessToken","type",0,10,"FORMAT_JSON");
    }

	private void getCompanyUpdates(String companyId, String accessToken, String type, int start, int count, String format) {
		try {
			String companyUpdates = getFeedService().getCompanyUpdates(companyId, accessToken, type, start, count, format);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
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
