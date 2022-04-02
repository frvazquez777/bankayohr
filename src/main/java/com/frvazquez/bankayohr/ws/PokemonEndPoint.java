package com.frvazquez.bankayohr.ws;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.frvazquez.bankayohr.constants.Constants;
import com.frvazquez.bankayohr.endpoint.GetAbilitiesRequest;
import com.frvazquez.bankayohr.endpoint.GetAbilitiesResponse;
import com.frvazquez.bankayohr.endpoint.GetBaseExperienceRequest;
import com.frvazquez.bankayohr.endpoint.GetBaseExperienceResponse;
import com.frvazquez.bankayohr.endpoint.GetHeldItemsRequest;
import com.frvazquez.bankayohr.endpoint.GetHeldItemsResponse;
import com.frvazquez.bankayohr.endpoint.GetIdRequest;
import com.frvazquez.bankayohr.endpoint.GetIdResponse;
import com.frvazquez.bankayohr.endpoint.GetLocationAreaEncountersRequest;
import com.frvazquez.bankayohr.endpoint.GetLocationAreaEncountersResponse;
import com.frvazquez.bankayohr.endpoint.GetNameRequest;
import com.frvazquez.bankayohr.endpoint.GetNameResponse;
import com.frvazquez.bankayohr.endpoint.GetRequest;
import com.frvazquez.bankayohr.endpoint.GetResponse;
import com.frvazquez.bankayohr.endpoint.Pokemon;
import com.frvazquez.bankayohr.service.PokemonService;

@Endpoint
public class PokemonEndPoint {

	protected static Logger LOG = LoggerFactory.getLogger(PokemonEndPoint.class);

	private static final String EMPTY_STRING = "";

	private PokemonService service;

	public PokemonEndPoint(PokemonService service) {
		this.service = service;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getRequest")
	@ResponsePayload
	public GetResponse getRequest(@RequestPayload GetRequest request) {
		LOG.info("getRequest...");
		GetResponse response = new GetResponse();
		response.setPokemon(service.getPokemon(request.getName()));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getAbilitiesRequest")
	@ResponsePayload
	public GetAbilitiesResponse getAbilitiesRequest(@RequestPayload GetAbilitiesRequest request) {
		LOG.info("getAbilitiesRequest...");

		GetAbilitiesResponse response = new GetAbilitiesResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.ABILITIES));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public GetBaseExperienceResponse getBaseExperienceRequest(@RequestPayload GetBaseExperienceRequest request) {
		LOG.info("getBaseExperienceRequest...");

		GetBaseExperienceResponse response = new GetBaseExperienceResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.BASE_EXPERIENCE));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public GetHeldItemsResponse getHeldItemsRequest(@RequestPayload GetHeldItemsRequest request) {
		LOG.info("getHeldItemsRequest...");

		GetHeldItemsResponse response = new GetHeldItemsResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.HELD_ITEMS));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public GetIdResponse getIdRequest(@RequestPayload GetIdRequest request) {
		LOG.info("getIdRequest...");

		GetIdResponse response = new GetIdResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.ID));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetNameResponse getNameRequest(@RequestPayload GetNameRequest request) {
		LOG.info("getNameRequest...");

		GetNameResponse response = new GetNameResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.NAME));

		return response;
	}

	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
	@ResponsePayload
	public GetLocationAreaEncountersResponse getLocationAreaEncountersRequest(
			@RequestPayload GetLocationAreaEncountersRequest request) {
		LOG.info("getLocationAreaEncountersRequest...");

		GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();
		Pokemon pokemon = service.getPokemon(request.getName());
		response.setPokemon(getPokemon(pokemon, Constants.LOCATION_AREA_ENCOUNTES));

		return response;
	}

	private Pokemon getPokemon(Pokemon pokemon, String type) {
		if (!Constants.ABILITIES.equals(type)) {
			pokemon.setAbilities(new ArrayList<>());
		}
		if (!Constants.BASE_EXPERIENCE.equals(type)) {
			pokemon.setBaseExperience(0);
		}
		if (!Constants.HELD_ITEMS.equals(type)) {
			pokemon.setHeldItems(new ArrayList<>());
		}
		if (!Constants.ID.equals(type)) {
			pokemon.setId(0);
		}
		if (!Constants.LOCATION_AREA_ENCOUNTES.equals(type)) {
			pokemon.setLocationAreaEncounters(EMPTY_STRING);
		}
		if (!Constants.NAME.equals(type)) {
			pokemon.setName(EMPTY_STRING);
		}
		return pokemon;
	}

}
