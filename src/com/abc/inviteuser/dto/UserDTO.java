package com.abc.inviteuser.dto;

import java.util.List;

public class UserDTO {

	@Override
	public String toString() {
		return "UserDTO [wooId=" + wooId + ", childrens=" + childrens + "]";
	}

	private long wooId;

	private List<UserDTO> childrens;
	
	public List<UserDTO> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<UserDTO> childrens) {
		this.childrens = childrens;
	}


	public long getWooId() {
		return wooId;
	}

	public void setWooId(long wooId) {
		this.wooId = wooId;
	}
	
}
