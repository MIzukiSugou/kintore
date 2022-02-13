package com.sugo.mizuki.domain.model;

/**
 * USER_MASTER Model
 * @author sugou
 * 
 */
public class UserMaster {
	
	//ユーザーID
	private String userId;
	
	//姓
	private String firstName;
	
	//名
	private String lastName;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
