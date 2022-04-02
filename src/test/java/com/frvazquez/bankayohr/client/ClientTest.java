package com.frvazquez.bankayohr.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frvazquez.bankayohr.constants.Constants;
import com.frvazquez.bankayohr.endpoint.vo.ResponseVO;

import reactor.core.publisher.Mono;

@SpringBootTest
public class ClientTest {

	private static final String POKEMON = "pikachu";
	private static final String POKEMON_NO_EXISTE = "yo";
	private static final String API = Constants.API;

	@Autowired
	Client client;

	@Test
	public void getApiRestTest() {

		Mono<ResponseVO> resultado = client.getApiRest(API + POKEMON, ResponseVO.class);

		ResponseVO response = resultado.block();

		assertNotNull(response);
		assertEquals(response.getName(), POKEMON);
	}

	@Test
	public void getApiRestNotFoundTest() {

		Mono<String> resultado = client.getApiRest(API + POKEMON_NO_EXISTE, String.class);

		assertNull(resultado.block());

	}
}
