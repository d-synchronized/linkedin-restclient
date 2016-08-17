package com.thread.dynamics.sn.dto.companies;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class CompanyPage {

	@JsonProperty("company")
	private Map<String,List<CompanyInfo>> companyDetail;

	public Map<String, List<CompanyInfo>> getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(Map<String, List<CompanyInfo>> companyDetail) {
		this.companyDetail = companyDetail;
	}
}
