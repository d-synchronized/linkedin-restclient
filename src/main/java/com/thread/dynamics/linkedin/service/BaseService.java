package com.thread.dynamics.linkedin.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.thread.dynamics.linkedin.dto.ApplicationConstant;

/**
 * The Class BaseService.
 *
 * @param <Resource> the generic type
 */
public abstract class BaseService<Resource> {
    
    protected String clientId;
    
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
