package com.thread.dynamics.linkedin.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.thread.dynamics.linkedin.dto.companies.CompanyPage;
import com.thread.dynamics.linkedin.exception.ServiceException;

public interface FeedService {

	
   CompanyPage  fetchCompaniesList(final String accessToken,final String query,final String types) throws ServiceException;
   
   String getCompanyUpdates(@PathParam("companyId")String companyId,@QueryParam("oauth2_access_token")String accessToken,@QueryParam("type") String type,@QueryParam("start")Integer start,@QueryParam("count") Integer count,@QueryParam("format") String format)  throws ServiceException; 


}
