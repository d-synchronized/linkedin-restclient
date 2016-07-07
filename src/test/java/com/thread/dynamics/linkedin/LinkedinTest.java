package com.thread.dynamics.linkedin;

import com.thread.dynamics.linkedin.dto.AccessTokenResponse;
import com.thread.dynamics.linkedin.dto.ContentData;
import com.thread.dynamics.linkedin.dto.PostData;
import com.thread.dynamics.linkedin.dto.PostDataOutput;
import com.thread.dynamics.linkedin.dto.VisibilityData;
import com.thread.dynamics.linkedin.dto.companies.CompanyPage;
import com.thread.dynamics.linkedin.dto.profile.BasicProfileInfo;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.service.AuthService;
import com.thread.dynamics.linkedin.service.FeedService;
import com.thread.dynamics.linkedin.service.PostService;
import com.thread.dynamics.linkedin.service.UserService;
import com.thread.dynamics.linkedin.service.impl.AuthServiceImpl;
import com.thread.dynamics.linkedin.service.impl.FeedServiceImpl;
import com.thread.dynamics.linkedin.service.impl.PostServiceImpl;
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

	private PostService postFeedService() {
		return new PostServiceImpl();
	}

	private String obtainAuthorizationCodeUrl(final String redirectUri) {
		final String requestUrl = getAuthService().obtainAuthorizationCodeUrl(redirectUri);
		return requestUrl;
	}

	private void obtainOauthToken(final String authorizationCode, final String redirectUri) throws ServiceException {
		final AccessTokenResponse accessTokenResponse = getAuthService().obtainOauthAccessToken(authorizationCode,
				redirectUri);
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
		final String redirectUri = "http://localhost:8080/mangle/api/v1/linkedin/callback";
		final LinkedinTest linkedinTest = new LinkedinTest();

	//	final String authorizationCodeUrl = linkedinTest.obtainAuthorizationCodeUrl(redirectUri);
	//	System.out.println(authorizationCodeUrl);

		// try {
		// linkedinTest.obtainOauthToken("AQR6akri7UJ7a-7cplmrWKT-Cb7AmfyiNm3pVLCx8w2X4UJ_c9BWUK2LYNROZb8xGGq9KOWfnXLiA7IJJ5m76mnGBKx22RvKnZSnC59RaSfMAYQufqU",
		// redirectUri);
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }

		// linkedinTest.postOnLinked("YOUR_ACCESS_CODE");

		// linkedinTest.getBasicProfileInfo("AQU7rFBxz7YrSKkqT4Y4ojnXRY80WjOOy2le00Zdm9zbmtGa2RV41WP-dS1mFnPw3Zk2FDsy3ZFcyTpv0BY6eA09_TARxTjIitbj7Yc85eI6jv0Hb9mtgGmYnMJK7J6sehdFsuL35sLtQHGgMH4nPXdGmJL_rIJptBo76VXbA_wAjP_gj4w");

		// String[] types={"type1","type2","type3"};

		// linkedinTest.getCompaniesList("accessToken","query",types);
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
	private void postOnLinked(final String accessToken) {
		String companyId = "2414183";
		PostData postData = new PostData();
		ContentData contentData = new ContentData();
		VisibilityData visibilityData = new VisibilityData();
		postData.setComment("Welcome to java Programming");
		contentData.setDescription("Software Engineer");
		contentData.setTitle("Amit 1234");
		contentData.setSubmittedUrl("dfgfffdgdf");
		contentData.setSubmittedImageUrl("fdgdfgdd");
		visibilityData.setCode("anyone");
		postData.setContentData(contentData);
		postData.setVisibilityData(visibilityData);
		PostDataOutput postDataOutput = null;
		try {
			postDataOutput = postFeedService().postFeed(accessToken, companyId, postData);
			System.out.println(postDataOutput);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
