package com.thread.dynamics.linkedin.service;

import java.util.List;
import java.util.Map;

import com.thread.dynamics.linkedin.dto.companies.CompanyInfo;
import com.thread.dynamics.linkedin.dto.companies.CompanyPage;
import com.thread.dynamics.linkedin.exception.ServiceException;

public interface FeedService {

	
   CompanyPage  fetchCompaniesList(final String accessToken,final String query,final String types) throws ServiceException;

}
