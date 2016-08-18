package com.thread.dynamics.sn.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class InstagramAccessTokenResponse {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("user")
	private InstagramUserResponse user;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public InstagramUserResponse getUser() {
		return user;
	}

	public void setUser(InstagramUserResponse user) {
		this.user = user;
	}

}
