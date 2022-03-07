package com.frvazquez.bankayohr.mapper;

import java.util.List;

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

public interface MapStructMapper {

	public Pokemon getResponseToPokemon(ResponseVO vo);

	public List<Abilities> getAbilitiesVoToListAbilities(List<AbilitiesVO> list);

	public Abilities getAbilitiesVoToAbilities(AbilitiesVO vo);

	public Ability getAbilityVoToAbility(AbilityVO vo);

	public List<HeldItems> getHeldItemsVoToListHeldItems(List<HeldItemVO> list);

	public HeldItems getHeldItemsVoToHeldItems(HeldItemVO vo);

	public Item getItemsVoToItems(ItemVO vo);

	public List<VersionDetail> getVersionDetailVoToListVersionDetail(List<VersionDetailVO> list);

	public VersionDetail getVersionDetailVoToVersionDetail(VersionDetailVO vo);

	public Versiones getVersionVoToVersion(VersionVO vo);

}
