package com.thread.dynamics.sn.service;

import com.thread.dynamics.sn.dto.profile.BasicProfileInfo;
import com.thread.dynamics.sn.exception.ServiceException;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
     * Gets the user profile info.
     *
     * @param acessToken the acess token
     * @return the user profile info
     * @throws ServiceException
     */
    BasicProfileInfo getUserProfileInfo(final String accessToken) throws ServiceException;

}
