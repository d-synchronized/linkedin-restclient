package com.thread.dynamics.linkedin.service.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.thread.dynamics.linkedin.dto.companies.CompanyInfo;
import com.thread.dynamics.linkedin.dto.companies.CompanyPage;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.resource.FeedResource;
import com.thread.dynamics.linkedin.service.BaseService;
import com.thread.dynamics.linkedin.service.FeedService;

/**
 * The Class FeedServiceImpl.
 */
public class FeedServiceImpl extends BaseService<FeedResource> implements FeedService {

    /**
     * Instantiates a new feed service impl.
     *
     * @param clazz the clazz
     */
    public FeedServiceImpl() {
        super(FeedResource.class);
    }

	@Override
	public CompanyPage fetchCompaniesList(String accessToken,String query,String types) throws ServiceException {
        final Response response = resource.fetchCompaniesList(accessToken, query,types);
        return handleResponse(response, CompanyPage.class, ServiceException.class);
	}

}
