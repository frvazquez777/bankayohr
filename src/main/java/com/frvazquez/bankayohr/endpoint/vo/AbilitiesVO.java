package com.frvazquez.bankayohr.endpoint.vo;

import java.io.Serializable;

public class AbilitiesVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AbilityVO ability;
	private Boolean is_hidden;
	private Integer slot;

	public AbilitiesVO() {
	}

	public AbilitiesVO(AbilityVO ability, Boolean is_hidden, Integer slot) {
		this.ability = ability;
		this.is_hidden = is_hidden;
		this.slot = slot;
	}

	public AbilityVO getAbility() {
		return ability;
	}

	public Boolean getIs_hidden() {
		return is_hidden;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setAbility(AbilityVO ability) {
		this.ability = ability;
	}

	public void setIs_hidden(Boolean is_hidden) {
		this.is_hidden = is_hidden;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "Ability [ability=" + ability + ", is_hidden=" + is_hidden + ", slot=" + slot + "]";
	}
}
