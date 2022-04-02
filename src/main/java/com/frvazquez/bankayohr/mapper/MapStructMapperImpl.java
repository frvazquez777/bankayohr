package com.frvazquez.bankayohr.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.frvazquez.bankayohr.endpoint.Abilities;
import com.frvazquez.bankayohr.endpoint.Ability;
import com.frvazquez.bankayohr.endpoint.HeldItems;
import com.frvazquez.bankayohr.endpoint.Item;
import com.frvazquez.bankayohr.endpoint.Pokemon;
import com.frvazquez.bankayohr.endpoint.Versiones;
import com.frvazquez.bankayohr.endpoint.VersionDetail;
import com.frvazquez.bankayohr.endpoint.vo.AbilitiesVO;
import com.frvazquez.bankayohr.endpoint.vo.AbilityVO;
import com.frvazquez.bankayohr.endpoint.vo.HeldItemVO;
import com.frvazquez.bankayohr.endpoint.vo.ItemVO;
import com.frvazquez.bankayohr.endpoint.vo.ResponseVO;
import com.frvazquez.bankayohr.endpoint.vo.VersionDetailVO;
import com.frvazquez.bankayohr.endpoint.vo.VersionVO;

@Component
public class MapStructMapperImpl implements MapStructMapper {

	@Override
	public Pokemon getResponseToPokemon(ResponseVO vo) {
		if (vo == null) {
			return null;
		}

		Pokemon mapper = new Pokemon();

		mapper.setAbilities(getAbilitiesVoToListAbilities(vo.getAbilities()));
		mapper.setBaseExperience(vo.getBase_experience());
		mapper.setHeldItems(getHeldItemsVoToListHeldItems(vo.getHeld_items()));
		mapper.setId(vo.getId());
		mapper.setLocationAreaEncounters(vo.getLocation_area_encounters());
		mapper.setName(vo.getName());
		return mapper;
	}

	@Override
	public List<Abilities> getAbilitiesVoToListAbilities(List<AbilitiesVO> list) {
		if (list.isEmpty())
			return new ArrayList<>();

		List<Abilities> mapperList = new ArrayList<>();
		for (AbilitiesVO vo : list) {
			mapperList.add(getAbilitiesVoToAbilities(vo));
		}
		return mapperList;
	}

	@Override
	public Abilities getAbilitiesVoToAbilities(AbilitiesVO vo) {
		if (vo == null) {
			return null;
		}

		Abilities mapper = new Abilities();
		mapper.setAbility(getAbilityVoToAbility(vo.getAbility()));
		mapper.setIsHidden(vo.getIs_hidden());
		mapper.setSlot(vo.getSlot());
		return mapper;
	}

	@Override
	public Ability getAbilityVoToAbility(AbilityVO vo) {
		if (vo == null) {
			return null;
		}

		Ability mapper = new Ability();
		mapper.setName(vo.getName());
		mapper.setUrl(vo.getUrl());
		return mapper;
	}

	@Override
	public List<HeldItems> getHeldItemsVoToListHeldItems(List<HeldItemVO> list) {
		if (list.isEmpty())
			return new ArrayList<>();

		List<HeldItems> mapperList = new ArrayList<>();
		for (HeldItemVO vo : list) {
			mapperList.add(getHeldItemsVoToHeldItems(vo));
		}
		return mapperList;
	}

	@Override
	public HeldItems getHeldItemsVoToHeldItems(HeldItemVO vo) {
		if (vo == null) {
			return null;
		}

		HeldItems mapper = new HeldItems();
		mapper.setVersionDetails(getVersionDetailVoToListVersionDetail(vo.getVersion_details()));
		mapper.setItem(getItemsVoToItems(vo.getItem()));
		return mapper;
	}

	@Override
	public Item getItemsVoToItems(ItemVO vo) {
		if (vo == null) {
			return null;
		}

		Item mapper = new Item();
		mapper.setName(vo.getName());
		mapper.setUrl(vo.getUrl());
		return mapper;
	}

	@Override
	public List<VersionDetail> getVersionDetailVoToListVersionDetail(List<VersionDetailVO> list) {
		if (list.isEmpty())
			return new ArrayList<>();

		List<VersionDetail> mapperList = new ArrayList<>();
		for (VersionDetailVO vo : list) {
			mapperList.add(getVersionDetailVoToVersionDetail(vo));
		}
		return mapperList;
	}

	@Override
	public VersionDetail getVersionDetailVoToVersionDetail(VersionDetailVO vo) {
		if (vo == null) {
			return null;
		}

		VersionDetail mapper = new VersionDetail();
		mapper.setRarity(vo.getRarity());
		mapper.setVersion(getVersionVoToVersion(vo.getVersion()));
		return mapper;
	}

	@Override
	public Versiones getVersionVoToVersion(VersionVO vo) {
		if (vo == null) {
			return null;
		}

		Versiones mapper = new Versiones();
		mapper.setName(vo.getName());
		mapper.setUrl(vo.getUrl());
		return mapper;
	}

}
