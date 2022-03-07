package com.frvazquez.bankayohr.endpoint.vo;

import java.io.Serializable;
import java.util.List;

public class HeldItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ItemVO item;
	private List<VersionDetailVO> version_details;

	public HeldItemVO() {
	}

	public HeldItemVO(ItemVO item, List<VersionDetailVO> version_details) {
		this.item = item;
		this.version_details = version_details;
	}

	public ItemVO getItem() {
		return item;
	}

	public List<VersionDetailVO> getVersion_details() {
		return version_details;
	}

	public void setItem(ItemVO item) {
		this.item = item;
	}

	public void setVersion_details(List<VersionDetailVO> version_details) {
		this.version_details = version_details;
	}

	@Override
	public String toString() {
		return "HeldItem [item=" + item + ", version_details=" + version_details + "]";
	}

}
