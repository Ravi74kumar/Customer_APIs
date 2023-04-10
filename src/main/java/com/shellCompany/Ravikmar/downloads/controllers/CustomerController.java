package com.shellCompany.Ravikmar.downloads.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shellCompany.Ravikmar.downloads.Service.ServiceCalls;
import com.shellCompany.Ravikmar.downloads.dto.CustomerDetails;
import com.shellCompany.Ravikmar.downloads.dto.CustomerRequest;
import com.shellCompany.Ravikmar.downloads.dto.CustomerResponse;
import com.shellCompany.Ravikumar.CRED.exceptions.CustomerException;

@RestController
public class CustomerController {
	
	@Value("${crud.api.url}")
	private String URL;
	
	@Value("${crud.api.addCustomer.service}")
	private String addCustomerService;
	
	@Value("${crud.api.getCustomer.service}")
	private String getCustomerService;
	
	@Autowired
	ServiceCalls serviceCalls;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer")
	public Object addCustomer(@RequestBody(required = false) CustomerRequest custReq ) {
		return serviceCalls.getResponse(URL + addCustomerService,  HttpMethod.PUT , custReq, CustomerRequest.class);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/GetCustomer")
	public Object retrieveCustomerDetails(@RequestParam(value = "custId", required = false) String custId) {
		if (StringUtils.isNotEmpty(custId)) {
			return serviceCalls.getResponse(URL + getCustomerService +"/"+custId, HttpMethod.GET, null, CustomerDetails.class);
		}
		return new ResponseEntity<CustomerException>(new CustomerException("Id not found", "No Id found in the Param"), HttpStatus.BAD_REQUEST);
	}

}
