package com.thread.dynamics.sn;

import com.thread.dynamics.sn.dto.AccessTokenResponse;
import com.thread.dynamics.sn.dto.companies.CompanyPage;
import com.thread.dynamics.sn.dto.profile.BasicProfileInfo;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.service.LinkedinAuthService;
import com.thread.dynamics.sn.service.LinkedinFeedService;
import com.thread.dynamics.sn.service.LinkedinUserService;
import com.thread.dynamics.sn.service.impl.LinkedinAuthServiceImpl;
import com.thread.dynamics.sn.service.impl.LinkedinFeedServiceImpl;
import com.thread.dynamics.sn.service.impl.LinkedinUserServiceImpl;

public class LinkedinTest {

    private LinkedinAuthService getAuthService() {
        final LinkedinAuthService authService = new LinkedinAuthServiceImpl("YOUR_CLIENT_ID", "YOUR_CLIENT_SECRET");
        return authService;
    }

    private LinkedinUserService getUserService() {
        return new LinkedinUserServiceImpl();
    }
    
    private LinkedinFeedService getFeedService() {
        return new LinkedinFeedServiceImpl();
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
