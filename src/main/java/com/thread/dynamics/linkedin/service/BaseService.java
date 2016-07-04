package com.thread.dynamics.linkedin.service;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;
import com.thread.dynamics.linkedin.exception.ErrorResponse;
import com.thread.dynamics.linkedin.exception.ServiceException;

/**
 * The Class BaseService.
 *
 * @param <Resource> the generic type
 */
public abstract class BaseService<Resource> {

    /** The client id. */
    protected String clientId;

    /** The client secret. */
    protected String clientSecret;

    /** The resource. */
    protected final Resource resource;

    /**
     * Instantiates a new base service.
     *
     * @param clazz the clazz
     */
    public BaseService(Class<Resource> clazz) {
        resource = getResourceProxy(clazz, ApplicationConstant.SERVER_URI);
    }

    /**
     * Handle response.
     *
     * @param <T> the generic type
     * @param <EX> the generic type
     * @param response the response
     * @param responseType the response type
     * @param exceptionClazz the exception clazz
     * @return the t
     * @throws EX the ex
     */
    public <T, EX extends ServiceException> T handleResponse(final Response response, final Class<T> responseType, final Class<EX> exceptionClazz) throws EX {
        validateResponseSuccess(response, responseType, exceptionClazz);
        final T responseEntity = response.readEntity(responseType);
        return responseEntity;
    }

    /**
     * Validate response success.
     *
     * @param <T> the generic type
     * @param <EX> the generic type
     * @param clientResponse the client response
     * @param responseType the response type
     * @param exceptionClazz the exception clazz
     * @throws EX the ex
     */
    protected <T, EX extends ServiceException> void validateResponseSuccess(final Response clientResponse, final Class<T> responseType, final Class<EX> exceptionClazz) throws EX {
        final Family statusFamily = Status.Family.familyOf(clientResponse.getStatus());
        if (statusFamily != Family.SUCCESSFUL) {
            Object errorResponse = null;
            Exception cause = null;
            try {
                errorResponse = clientResponse.readEntity(String.class);
            } catch (final Exception responseFailure) {
                System.out.println(responseFailure);
                cause = responseFailure;
            }
            EX exception = null;
            final String genericErrorMsg = "Error occurred while creating new instance of exception class of type "
                + exceptionClazz.getCanonicalName()
                + " to throw the following error:\n" + errorResponse;
            try {
                if (cause != null) {
                    exception = exceptionClazz.getConstructor(String.class,
                        Throwable.class).newInstance("An error occurred while fetching entity from HTTP response:\n" + errorResponse,
                            cause);
                } else {
                    exception = exceptionClazz.getConstructor(String.class)
                        .newInstance(
                            "Request processing failed.\n HTTP Status: "
                                + "\n HTTP Status Code:"
                                + clientResponse.getStatus()
                                + " \n Error:" + errorResponse);
                }
                if (exception != null && errorResponse instanceof com.thread.dynamics.linkedin.exception.ErrorResponse) {
                    exception.setErrorResponse((ErrorResponse) errorResponse);
                }
            } catch (final IllegalArgumentException iae) {
                throw new IllegalStateException(genericErrorMsg, iae);
            } catch (final SecurityException se) {
                throw new IllegalStateException(genericErrorMsg, se);
            } catch (final InstantiationException ie) {
                throw new IllegalStateException(genericErrorMsg, ie);
            } catch (final IllegalAccessException iacce) {
                throw new IllegalStateException(genericErrorMsg, iacce);
            } catch (final InvocationTargetException ite) {
                throw new IllegalStateException(genericErrorMsg, ite);
            } catch (final NoSuchMethodException nsme) {
                throw new IllegalStateException(genericErrorMsg, nsme);
            }
            throw exception;
        }
    }

    /**
     * Gets the resource proxy.
     *
     * @param resourceClazz the resource clazz
     * @param serverUri the server uri
     * @return the resource proxy
     */
    public Resource getResourceProxy(final Class<Resource> resourceClazz, final String serverUri) {
        final ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target(serverUri);
        return resteasyWebTarget.proxy(resourceClazz);
    }

}
