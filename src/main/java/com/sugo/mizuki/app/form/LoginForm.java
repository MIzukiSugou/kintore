package com.sugo.mizuki.app.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.sugo.mizuki.app.common.ValidationPattern;

/**
 * ログイン画面 フォーム
 * @author sugou
 *
 */
public class LoginForm implements Serializable {
	
	private static final long serialVersionUID = -8238758270284186778L;

	//ユーザーId
	@NotEmpty(message = "{Customer.useridNotInput.invalid}")
	@Pattern(regexp = ValidationPattern.USER_ID_PATTERN, message = "{Customer.patternmisUserid.invalid}")
	private String userId;

	//パスワード
	@NotEmpty(message = "{Customer.passwordNotInput.invalid}")
	@Pattern(regexp = ValidationPattern.PASSWORD_PATTERN, message = "{Customer.patternmisPassword.invalid}")
	private String password;

	//ログインエラーメッセージ
	private String errorMessage;

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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}