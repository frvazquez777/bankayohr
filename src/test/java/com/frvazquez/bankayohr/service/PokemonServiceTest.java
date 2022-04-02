package com.frvazquez.bankayohr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.frvazquez.bankayohr.client.Client;
import com.frvazquez.bankayohr.domain.Request;
import com.frvazquez.bankayohr.endpoint.Pokemon;
import com.frvazquez.bankayohr.endpoint.vo.ResponseVO;
import com.frvazquez.bankayohr.mapper.MapStructMapper;
import com.frvazquez.bankayohr.repository.RequestRepository;
import com.frvazquez.bankayohr.util.FileUtil;

import reactor.core.publisher.Mono;

public class PokemonServiceTest {

	private static final String POKEMON = "pikachu";
	private static final File file = new File("src/test/resources/pokemon.json");
	private static Pokemon POKEMON_EXPECT;
	private static Request REQUEST;

	@InjectMocks
	PokemonService service;
	@Mock
	private Client client;
	@Mock
	private RequestRepository repository;
	@Mock
	private MapStructMapper mapper;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		init();
	}

	private void init() {
		POKEMON_EXPECT = new Pokemon();
		POKEMON_EXPECT.setName(POKEMON);

		REQUEST = new Request();
		REQUEST.setId(1L);
		REQUEST.setIpOrigen("192.168.0.1");
		REQUEST.setMetodo("getRequest");
	}

	@Test
	@DisplayName("getPokemon - PokemoService | Prueba de solicto API y mapper :D")
	public void getPokemonTest() throws IOException {
		String info = FileUtil.getData(file);
		Mockito.when(client.getApiRest(Mockito.anyString(), Mockito.eq(String.class))).thenReturn(Mono.just(info));
		Mockito.when(mapper.getResponseToPokemon(Mockito.any(ResponseVO.class))).thenReturn(POKEMON_EXPECT);

		service.init();
		Pokemon resultado = service.getPokemonString(POKEMON);

		assertEquals(POKEMON_EXPECT.getName(), resultado.getName());
	}
	
	@Test
	@DisplayName("getPokemon - PokemoService | Prueba de solicto API y mapper VO :D")
	public void getPokemonVoTest() throws IOException {
		ResponseVO vo = new ResponseVO();
		vo.setName(POKEMON);
		Mockito.when(client.getApiRest(Mockito.anyString(), Mockito.eq(ResponseVO.class))).thenReturn(Mono.just(vo));
		Mockito.when(mapper.getResponseToPokemon(Mockito.any(ResponseVO.class))).thenReturn(POKEMON_EXPECT);

		Pokemon resultado = service.getPokemon(POKEMON);

		assertEquals(POKEMON_EXPECT.getName(), resultado.getName());
	}

	@Test
	@DisplayName("save - PokemoService | Prueba de guardado :D")
	public void saveTest() {
		Mockito.when(repository.save(REQUEST)).thenReturn(REQUEST);
		Request resultado = service.save(REQUEST);

		assertEquals(REQUEST.getIpOrigen(), resultado.getIpOrigen());

	}
}
