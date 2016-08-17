package com.thread.dynamics.sn.exception;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;


public class ErrorResponse {
    
    @JsonProperty
    private ErrorCode errorCode;

    /** The message. */
    @JsonProperty
    private String message;

    /** The errors. */
    @JsonProperty
    private Map<String, String> errors;

    /** The application errors. */
    @JsonProperty
    private Map<String, Map<String, String>> applicationErrors;

}
