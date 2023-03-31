package com.shellCompany.Ravikmar.downloads.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shellCompany.Ravikmar.downloads.Service.ServiceCalls;
import com.shellCompany.Ravikmar.downloads.dto.CustomerRequest;
import com.shellCompany.Ravikmar.downloads.dto.CustomerResponse;

@RestController
public class CustomerController {
	
	@Value("${crud.api.url}")
	private String URL;
	
	@Value("${crud.api.addCustomer.service}")
	private String addCustomerService;
	
	@Autowired
	ServiceCalls serviceCalls;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer")
	public Object addCustomer(@RequestBody(required = false) CustomerRequest custReq ) {
		return serviceCalls.getResponse(URL + addCustomerService,  HttpMethod.PUT , custReq, CustomerRequest.class);
	}

}
