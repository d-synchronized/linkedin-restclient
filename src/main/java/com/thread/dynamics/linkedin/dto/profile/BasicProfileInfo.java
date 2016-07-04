package com.thread.dynamics.linkedin.dto.profile;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The Class BasicProfileInfo.
 */
public class BasicProfileInfo {

    /** The id. */
    private String id;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The headline. */
    private String headline;

    /** The standard profile request. */
    @JsonProperty("siteStandardProfileRequest")
    private SiteStandardProfileRequest standardProfileRequest;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the headline.
     *
     * @return the headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Sets the headline.
     *
     * @param headline the new headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * Gets the standard profile request.
     *
     * @return the standard profile request
     */
    public SiteStandardProfileRequest getStandardProfileRequest() {
        return standardProfileRequest;
    }

    /**
     * Sets the standard profile request.
     *
     * @param standardProfileRequest the new standard profile request
     */
    public void setStandardProfileRequest(SiteStandardProfileRequest standardProfileRequest) {
        this.standardProfileRequest = standardProfileRequest;
    }

}
