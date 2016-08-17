package com.thread.dynamics.sn.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.sn.dto.companies.CompanyPage;
import com.thread.dynamics.sn.exception.ServiceException;
import com.thread.dynamics.sn.resource.LinkedinFeedResource;
import com.thread.dynamics.sn.service.BaseService;
import com.thread.dynamics.sn.service.LinkedinFeedService;

/**
 * The Class FeedServiceImpl.
 */
public class LinkedinFeedServiceImpl extends BaseService<LinkedinFeedResource> implements LinkedinFeedService {

    /**
     * Instantiates a new feed service impl.
     *
     * @param clazz the clazz
     */
    public LinkedinFeedServiceImpl() {
        super(LinkedinFeedResource.class);
    }

	@Override
	public CompanyPage fetchCompaniesList(String accessToken,String query,String types) throws ServiceException {
        final Response response = resource.fetchCompaniesList(accessToken, query,types);
        return handleResponse(response, CompanyPage.class, ServiceException.class);
	}

	@Override
	//change return type from string to json later.
	public String getCompanyUpdates(String companyId, String accessToken, String type, Integer start, Integer count,
			String format) throws ServiceException {
			final Response response =resource.getCompanyUpdates(companyId, accessToken, type, start, count, format);
			 return handleResponse(response, String.class, ServiceException.class);
	
	}

}
