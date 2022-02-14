package com.sugo.mizuki.app.common;

/**
 * 正規表現
 * @author sugou
 *
 */
public class ValidationPattern {
	//ユーザーIDパターン
	public static final String USER_ID_PATTERN = "^([a-zA-Z0-9]{6,10})?$";
	//パスワードパターン
	public static final String PASSWORD_PATTERN = "^([a-zA-Z0-9]{8,15})?$";
}
