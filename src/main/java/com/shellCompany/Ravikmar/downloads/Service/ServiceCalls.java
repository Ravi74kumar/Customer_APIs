package com.shellCompany.Ravikmar.downloads.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shellCompany.Ravikmar.downloads.dto.CustomerRequest;

@Service
public class ServiceCalls {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Object getResponse(String url, HttpMethod methodType, Object requestObject, Class responseClassType) {
		HttpEntity requestEntity = new HttpEntity(requestObject);
		ResponseEntity responseEntity = restTemplate.exchange(url, methodType, requestEntity, responseClassType);
		return responseEntity.getBody();
	}

}
