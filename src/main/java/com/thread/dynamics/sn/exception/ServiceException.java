package com.thread.dynamics.sn.exception;

/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -413837058560354373L;

    /** The error response. */
    private ErrorResponse errorResponse;

    /**
     * Transformer exception.
     *
     * @param message the message
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Transformer exception.
     *
     * @param throwable the throwable
     */
    public ServiceException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * Transformer exception.
     *
     * @param message the message
     * @param throwable the throwable
     */
    public ServiceException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Gets the error response.
     *
     * @return the error response
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    /**
     * Sets the error response.
     *
     * @param errorResponse the new error response
     */
    public void setErrorResponse(final ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
