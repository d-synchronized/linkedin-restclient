package com.thread.dynamics.linkedin.exception;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;


public enum ErrorCode {
    
    /** The none. */
    NONE(1000),

    /** The generic server error. */
    GENERIC_SERVER_ERROR(1001),

    /** The resource not found. */
    RESOURCE_NOT_FOUND(1002),

    /** The malformed auth request. */
    MALFORMED_AUTH_REQUEST(1003),

    /** The authentication failure. */
    AUTHENTICATION_FAILURE(1004),

    /** The authentication required. */
    AUTHENTICATION_REQUIRED(1005),

    /** The user session required. */
    USER_SESSION_REQUIRED(1006),

    /** The guest required. */
    GUEST_REQUIRED(1007),

    /** The authorization failure. */
    AUTHORIZATION_FAILURE(1008),

    /** The generic authentication error. */
    GENERIC_AUTHENTICATION_ERROR(1009),

    /** The parameter missing invalid. */
    PARAMETER_MISSING_INVALID(1010),

    /** The unprocessable entity. */
    UNPROCESSABLE_ENTITY(1011),

    /** The resource already processed. */
    RESOURCE_ALREADY_PROCESSED(1012),

    /** The resource expired. */
    RESOURCE_EXPIRED(1013),

    /** The entity already exists. */
    ENTITY_ALREADY_EXISTS(1014),

    /** The resource not accessible. */
    RESOURCE_NOT_ACCESSIBLE(1015),

    /** The resource not modified. */
    RESOURCE_NOT_MODIFIED(1016),

    /** The malformed request format. */
    MALFORMED_REQUEST_FORMAT(1017),

    /** The unsupported media type. */
    UNSUPPORTED_MEDIA_TYPE(1018);
    
    /** The value. */
    private final int value;

    /**
     * Instantiates a new error code.
     *
     * @param value the value
     */
    ErrorCode(final int value) {
        this.value = value;
    }

    /**
     * Value.
     *
     * @return the int
     */
    @JsonValue
    public int value() {
        return value;
    }

    /**
     * From value.
     *
     * @param typeCode the type code
     * @return the error code
     */
    @JsonCreator
    public static ErrorCode fromValue(final int typeCode) {
        for (final ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.value == typeCode) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("Invalid Status type code: " + typeCode);

    }

}
