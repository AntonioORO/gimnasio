package com.aoro.gimnasio.repository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.aoro.gimnasio.model.ResponseGenericDto;

@Repository
public class BackendRepository {
	Logger logger = Logger.getLogger(BackendRepository.class.getName());

	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseGenericDto callPost(Object params,String token,String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpEntity = new HttpEntity<>(params, headers);
		ResponseGenericDto response = restTemplate.postForObject(path, httpEntity,ResponseGenericDto.class);
		logger.info("Response "+path+" -> "+response);
		return response;
		
	}
	
}
