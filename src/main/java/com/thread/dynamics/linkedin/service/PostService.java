package com.thread.dynamics.linkedin.service;

import com.thread.dynamics.linkedin.dto.PostData;
import com.thread.dynamics.linkedin.dto.PostDataOutput;
import com.thread.dynamics.linkedin.exception.ServiceException;

public interface PostService {

	PostDataOutput postFeed(final String accessToken, String companyId, PostData postData) throws ServiceException;
}
