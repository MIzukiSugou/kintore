package com.sugo.mizuki.domain.condition;

/**
 * USER_MASTER sql条件クラス
 * @author sugou
 *
 */
public class UserMasterCondition {
	
	//ユーザーID
	private String userId;
	
	//パスワード
	private String password;
	
	//アカウントロックフラグ(1:ON)
	private String accountLockFlagOn;
	
	//アカウントロックフラグ(0:OFF)
	private String accountLockFlagOff;
	
	//削除フラグ(1:ON)
	private String deleteFlagOn;
	
	//削除フラグ(0:OFF)
	private String deleteFlagOff;
	
	//ログイン失敗回数
	private int loginFailureCount;
	
	//ログイン失敗最大回数
	private int loginFailureMaxCount;
	
	//ログイン回数
	private int loginCount;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountLockFlagOn() {
		return accountLockFlagOn;
	}

	public void setAccountLockFlagOn(String accountLockFlagOn) {
		this.accountLockFlagOn = accountLockFlagOn;
	}

	public String getAccountLockFlagOff() {
		return accountLockFlagOff;
	}

	public void setAccountLockFlagOff(String accountLockFlagOff) {
		this.accountLockFlagOff = accountLockFlagOff;
	}

	public String getDeleteFlagOn() {
		return deleteFlagOn;
	}

	public void setDeleteFlagOn(String deleteFlagOn) {
		this.deleteFlagOn = deleteFlagOn;
	}

	public String getDeleteFlagOff() {
		return deleteFlagOff;
	}

	public void setDeleteFlagOff(String deleteFlagOff) {
		this.deleteFlagOff = deleteFlagOff;
	}

	public int getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(int loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public int getLoginFailureMaxCount() {
		return loginFailureMaxCount;
	}

	public void setLoginFailureMaxCount(int loginFailureMaxCount) {
		this.loginFailureMaxCount = loginFailureMaxCount;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
}
