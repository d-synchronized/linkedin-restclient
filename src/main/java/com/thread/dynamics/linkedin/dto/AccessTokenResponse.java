package com.thread.dynamics.linkedin.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The Class AccessTokenResponse.
 */
public class AccessTokenResponse {

    /** The access token. */
    @JsonProperty("access_token")
    private String accessToken;

    /** The expires in. */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * Gets the access token.
     *
     * @return the access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     *
     * @param accessToken the new access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets the expires in.
     *
     * @return the expires in
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the expires in.
     *
     * @param expiresIn the new expires in
     */
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
