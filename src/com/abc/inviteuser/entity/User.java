package com.abc.inviteuser.entity;

import java.util.List;

public class User {

	private long wooId;

	private List<User> childrens;
	
	@Override
	public String toString() {
		return "User [wooId=" + wooId + ", childrens=" + childrens + "]";
	}

	public List<User> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<User> childrens) {
		this.childrens = childrens;
	}


	public long getWooId() {
		return wooId;
	}

	public void setWooId(long wooId) {
		this.wooId = wooId;
	}

}
