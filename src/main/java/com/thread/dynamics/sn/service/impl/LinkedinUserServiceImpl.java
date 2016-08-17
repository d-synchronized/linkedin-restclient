package com.thread.dynamics.sn.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.sn.dto.profile.BasicProfileInfo;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.resource.LinkedinUserResource;
import com.thread.dynamics.sn.service.BaseService;
import com.thread.dynamics.sn.service.LinkedinUserService;

/**
 * The Class UserServiceImpl.
 */
public class LinkedinUserServiceImpl extends BaseService<LinkedinUserResource> implements LinkedinUserService {

    private static final String FORMAT_JSON = "json";

    /**
     * Instantiates a new user service impl.
     */
    public LinkedinUserServiceImpl() {
        super(LinkedinUserResource.class);
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
