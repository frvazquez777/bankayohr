package com.frvazquez.bankayohr.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.frvazquez.bankayohr.client.Client;
import com.frvazquez.bankayohr.constants.Constants;
import com.frvazquez.bankayohr.domain.Request;
import com.frvazquez.bankayohr.endpoint.Pokemon;
import com.frvazquez.bankayohr.endpoint.vo.ResponseVO;
import com.frvazquez.bankayohr.mapper.MapStructMapper;
import com.frvazquez.bankayohr.repository.RequestRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import reactor.core.publisher.Mono;

@Service
public class PokemonService {

	protected static Logger LOG = LoggerFactory.getLogger(PokemonService.class);

	private Client client;
	private RequestRepository repository;
	private MapStructMapper mapper;
	private Gson gson;

	public PokemonService(Client client, MapStructMapper mapper, RequestRepository repository) {
		this.client = client;
		this.mapper = mapper;
		this.repository = repository;
	}

	@PostConstruct
	public void init() {
		gson = new GsonBuilder().create();

	}

	public Pokemon getPokemon(String pokemon) {
		LOG.info("----------------------------------------------------------------------------");
		LOG.info("Peticion al servicio web...");
		Pokemon response = new Pokemon();
		Mono<String> resultado = client.getApiRest(Constants.API + pokemon, String.class);
		if (null != resultado.block()) {
			String json = resultado.block();
			ResponseVO vo = gson.fromJson(String.valueOf(json), ResponseVO.class);
			response = mapper.getResponseToPokemon(vo);
			LOG.info("Cargando informacion para el retorno");
		}
		LOG.info("----------------------------------------------------------------------------");
		return response;

	}
	
	
	public Request save(Request request) {
		LOG.info("----------------------------------------------------------------------------");
		LOG.info("Save request");
		LOG.info(request.toString());
		LOG.info("----------------------------------------------------------------------------");
		
		return repository.save(request);
	}
	
	
}
