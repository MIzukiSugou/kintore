package com.sugo.mizuki.domain.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugo.mizuki.app.common.CommonConst;
import com.sugo.mizuki.app.form.LoginForm;
import com.sugo.mizuki.domain.condition.UserMasterCondition;
import com.sugo.mizuki.domain.model.UserMaster;
import com.sugo.mizuki.domain.repository.UserMasterRepository;

/**
 * ログイン画面サービスクラス
 * @author sugou
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** アカウントロックフラグ(0:OＮ) */
	private final String ACCOUNT_LOCK_FLAG_ON = "1";
	
	/** アカウントロックフラグ(0:OFF) */
	private final String ACCOUNT_LOCK_FLAG_OFF = "0";
	
	/** 削除フラグ(0:OFF) */
	private final String DELETE_FLAG_OFF = "0";

	/** ログイン回数 */
	private final int LOGIN_COUNT = 1;
	
	/** ログイン失敗回数 */
	private final int LOGIN_FAILURE_COUNT = 1;
	
	/** ログイン失敗最大回数 */
	private final int LOGIN_FAILURE_MAX_COUNT = 10;
	
	/** ログイン失敗 */
	private final String LOGIN_ERROR= "ユーザーID、パスワードのいずれかに誤りがあります。";
	
	@Autowired
	UserMasterRepository userMasterRepository;
	
    /**
     * 入力チェック
     *
     * @param form ログイン画面フォーム
     * @return true:正常 false:エラー
     */
	@Override
	public boolean checkInput(LoginForm form) {
		
		UserMasterCondition userMasterCondition = new UserMasterCondition();
		userMasterCondition.setUserId(form.getUserId());
		userMasterCondition.setPassword(form.getPassword());
		userMasterCondition.setAccountLockFlagOff(ACCOUNT_LOCK_FLAG_OFF);
		userMasterCondition.setDeleteFlagOff(DELETE_FLAG_OFF);
		
		if  (userMasterRepository.checkLogin(userMasterCondition) > 0) {
			// ユーザ情報が存在する場合
			return true;
			
		} else {
			// ユーザ情報が存在しない場合
            form.setErrorMessage(LOGIN_ERROR);			
			userMasterCondition = new UserMasterCondition();
			userMasterCondition.setLoginFailureCount(LOGIN_FAILURE_COUNT);
			userMasterCondition.setLoginFailureMaxCount(LOGIN_FAILURE_MAX_COUNT);
			userMasterCondition.setAccountLockFlagOn(ACCOUNT_LOCK_FLAG_ON);
			userMasterCondition.setAccountLockFlagOff(ACCOUNT_LOCK_FLAG_OFF);
			userMasterCondition.setUserId(form.getUserId());
			userMasterCondition.setDeleteFlagOff(DELETE_FLAG_OFF);
			// ユーザ情報の更新
			userMasterRepository.updateLoginFailure(userMasterCondition);
			return false;
		}
		
	}
	
    /**
     * ログイン処理
     *
     * @param form ログインフォーム
     * @param session セッション情報
     * @return true:成功 false:失敗
     */
	@Override
	public boolean executeLogin(LoginForm form, HttpSession session) {
		
		UserMasterCondition userMasterCondition = new UserMasterCondition();
		//ユーザー情報取得
		userMasterCondition.setUserId(form.getUserId());
		userMasterCondition.setDeleteFlagOff(DELETE_FLAG_OFF);
		UserMaster userMaster = userMasterRepository.selectUser(userMasterCondition) ;
		
		if  (userMaster != null ) {
			// 取得成功の場合
	        session.setAttribute(CommonConst.LOGIN_USER_INFO, userMaster);
	        // ユーザ情報の更新
	        userMasterCondition = new UserMasterCondition();
	        userMasterCondition.setLoginCount(LOGIN_COUNT);
	        userMasterCondition.setLoginFailureCount(LOGIN_FAILURE_COUNT);
	        userMasterCondition.setUserId(form.getUserId());
	        userMasterCondition.setDeleteFlagOn(DELETE_FLAG_OFF);
	        userMasterRepository.updateLoginSuccess(userMasterCondition);
			return true;
		} else {
			//取得エラーの場合
            form.setErrorMessage(LOGIN_ERROR);		
			return false;
		}
	}

}
