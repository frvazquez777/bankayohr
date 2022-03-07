package com.frvazquez.bankayohr.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Mono;

@Component
public class Client {

	protected static Logger LOG = LoggerFactory.getLogger(Client.class);

	RestTemplate restTemplate;
	
	public Client(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public <T> Mono<T> getApiRest(String api, Class<T> typeObject) {
		try {
			LOG.info("Petición API...");
			return Mono.just(restTemplate.getForObject(api, typeObject));

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} 
		return Mono.empty();
	}

	

}
