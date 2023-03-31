package com.shellCompany.Ravikmar.downloads.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shellCompany.Ravikmar.downloads.dto.CustomerRequest;
import com.shellCompany.Ravikmar.downloads.dto.CustomerResponse;

@RestController
public class Maincontroller {
	
	@RequestMapping(method = RequestMethod.GET, path = "/alive" )
	public byte[] queryAlive() {
		return new byte[0];
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getName(@RequestParam(required = false, value = "name") String name) {
		if(StringUtils.isNotEmpty(name)) {
			return name;
		}
		return "No Name Found";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/balance")
	public CustomerResponse getBalance(@RequestParam (required = false, value = "custId") Long custID) {
		CustomerResponse cr = new CustomerResponse();
		cr.setCustId(custID);
		cr.setBalance(345834.6d);
		return cr;
	}
	
	
	
	

}
