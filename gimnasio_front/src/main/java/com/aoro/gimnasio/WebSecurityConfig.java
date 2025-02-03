package com.aoro.gimnasio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.google.gson.Gson;

@Component
public class WebSecurityConfig  {
  
	@Value("${api.backend.host.baseurl}")
	private String apiHost;
		
	@Bean
    public Gson gson() {
        return  new Gson();
    }
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate();
    	restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiHost));
    	return restTemplate;
    }

   
  }