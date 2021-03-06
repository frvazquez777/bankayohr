package com.frvazquez.bankayohr.endpoint.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String name;
    private String url;

    public AbilityVO() {
    }

    public AbilityVO(String name, String url) {
        this.name = name;
        this.url = url;
    }

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
