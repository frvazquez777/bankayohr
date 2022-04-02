package com.frvazquez.bankayohr.endpoint.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<AbilitiesVO> abilities;
	private Integer base_experience;
	private List<HeldItemVO> held_items;
	private Integer id;
	private String name;
	private String location_area_encounters;
	
	public ResponseVO() {
	}

	public ResponseVO(List<AbilitiesVO> abilities, Integer base_experience, List<HeldItemVO> held_items, Integer id, String name,
			String location_area_encounters) {
		this.abilities = abilities;
		this.base_experience = base_experience;
		this.held_items = held_items;
		this.id = id;
		this.name = name;
		this.location_area_encounters = location_area_encounters;
	}

	public List<AbilitiesVO> getAbilities() {
		return abilities;
	}

	public Integer getBase_experience() {
		return base_experience;
	}

	public List<HeldItemVO> getHeld_items() {
		return held_items;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation_area_encounters() {
		return location_area_encounters;
	}

	public void setAbilities(List<AbilitiesVO> abilities) {
		this.abilities = abilities;
	}

	public void setBase_experience(Integer base_experience) {
		this.base_experience = base_experience;
	}

	public void setHeld_items(List<HeldItemVO> held_items) {
		this.held_items = held_items;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation_area_encounters(String location_area_encounters) {
		this.location_area_encounters = location_area_encounters;
	}

	@Override
	public String toString() {
		return "Response [abilities=" + abilities + ", base_experience=" + base_experience + ", held_items="
				+ held_items + ", id=" + id + ", name=" + name + ", location_area_encounters="
				+ location_area_encounters + "]";
	}

	

}
