package com.frvazquez.bankayohr.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frvazquez.bankayohr.constants.Constants;
import com.frvazquez.bankayohr.endpoint.vo.ResponseVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import reactor.core.publisher.Mono;

@SpringBootTest
public class ClientTest {

	private static final String POKEMON = "pikachu";
	private static final String POKEMON_NO_EXISTE = "yo";
	private static final String API = Constants.API;

	private static Gson gson;

	@Autowired
	Client client;

	@BeforeAll
	public static void setUpAll() {
		gson = new GsonBuilder().create();
	}

	@Test
	public void getApiRestTest() {

		Mono<String> resultado = client.getApiRest(API+POKEMON, String.class);

		String json = resultado.block();
		ResponseVO response = gson.fromJson(String.valueOf(json), ResponseVO.class);
		System.out.println(json);
		System.out.println(response);
		assertNotNull(response);
		assertTrue(json.contains(POKEMON));
	}
	


	@Test
	public void getApiRestNotFoundTest() {

		Mono<String> resultado = client.getApiRest(API+POKEMON_NO_EXISTE, String.class);

		assertNull(resultado.block());

		
	}
}
