package com.frvazquez.bankayohr.endpoint.vo;

import java.io.Serializable;

public class VersionDetailVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rarity;
	private VersionVO version;

	public VersionDetailVO() {
	}

	public VersionDetailVO(Integer rarity, VersionVO version) {
		this.rarity = rarity;
		this.version = version;
	}

	public Integer getRarity() {
		return rarity;
	}

	public VersionVO getVersion() {
		return version;
	}

	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}

	public void setVersion(VersionVO version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VersionDetail [rarity=" + rarity + ", version=" + version + "]";
	}

}
