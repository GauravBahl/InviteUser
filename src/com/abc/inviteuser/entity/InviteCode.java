package com.abc.inviteuser.entity;

import org.joda.time.DateTime;

public class InviteCode {
	
	@Override
	public String toString() {
		return "InviteCode [id=" + id + ", wooId=" + wooId + ", counter=" + counter + ", creationDate=" + creationDate
				+ ", validityDate=" + validityDate + ", lastUpdatedDate=" + lastUpdatedDate + ", code=" + code
				+ ", validOrNot=" + validOrNot + "]";
	}

	private long id;
	
	private long wooId;
	
	private long counter;
	
	private DateTime creationDate;
	
	private DateTime validityDate;
	
	private DateTime lastUpdatedDate;
	
	private String code;
	
	private boolean validOrNot;
	
	
	public boolean isValidOrNot() {
		return validOrNot;
	}

	public void setValidOrNot(boolean validOrNot) {
		this.validOrNot = validOrNot;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWooId() {
		return wooId;
	}

	public void setWooId(long wooId) {
		this.wooId = wooId;
	}

	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public DateTime getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(DateTime validityDate) {
		this.validityDate = validityDate;
	}

	public DateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(DateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
