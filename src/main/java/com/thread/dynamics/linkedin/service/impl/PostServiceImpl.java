package com.thread.dynamics.linkedin.service.impl;

import javax.ws.rs.core.Response;

import com.thread.dynamics.linkedin.dto.PostData;
import com.thread.dynamics.linkedin.dto.PostDataOutput;
import com.thread.dynamics.linkedin.exception.ServiceException;
import com.thread.dynamics.linkedin.resource.PostResource;
import com.thread.dynamics.linkedin.service.BaseService;
import com.thread.dynamics.linkedin.service.PostService;

public class PostServiceImpl extends BaseService<PostResource> implements PostService {
	private static final String FORMAT_JSON = "json";

	public PostServiceImpl() {
		super(PostResource.class);
	}

	@Override
	public PostDataOutput postFeed(String accessToken, String companyId, PostData postData) throws ServiceException {

		final Response response = resource.postFeed(accessToken, companyId, postData, FORMAT_JSON);
		return handleResponse(response, PostDataOutput.class, ServiceException.class);
	}

}
