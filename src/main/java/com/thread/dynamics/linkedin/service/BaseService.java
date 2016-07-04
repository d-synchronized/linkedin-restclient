package com.thread.dynamics.linkedin.service;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;
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
