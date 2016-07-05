package com.thread.dynamics.linkedin.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.linkedin.dto.profile.BasicProfileInfo;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.resource.UserResource;
import com.thread.dynamics.linkedin.service.BaseService;
import com.thread.dynamics.linkedin.service.UserService;

/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl extends BaseService<UserResource> implements UserService {

    private static final String FORMAT_JSON = "json";

    /**
     * Instantiates a new user service impl.
     */
    public UserServiceImpl() {
        super(UserResource.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.thread.dynamics.linkedin.service.UserService#getUserProfileInfo(java.lang.String)
     */
    @Override
    public BasicProfileInfo getUserProfileInfo(final String accessToken) throws ServiceException {
        final Response response = resource.fetchBasicUserProfile(accessToken, FORMAT_JSON);
        return handleResponse(response, BasicProfileInfo.class, ServiceException.class);
    }

}