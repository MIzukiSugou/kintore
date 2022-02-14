package com.sugo.mizuki.domain.service;

import javax.servlet.http.HttpSession;

import com.sugo.mizuki.app.form.LoginForm;

/**
 * ログイン画面サービスクラス
 * @author sugou
 */
public interface LoginService {

    /**
     * 入力チェック
     *
     * @param form ログイン画面フォーム
     * @return true:正常 false:エラー
     */
	public boolean checkInput(LoginForm form) ;
	
    /**
     * ログイン処理
     *
     * @param form ログインフォーム
     * @param session セッション情報
     * @return true:成功 false:失敗
     */
	public boolean executeLogin(LoginForm form, HttpSession session) ;
}
