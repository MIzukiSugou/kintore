/**
 * 
 */
package com.sugo.mizuki.domain.repository;

import com.sugo.mizuki.domain.condition.UserMasterCondition;
import com.sugo.mizuki.domain.model.UserMaster;

/**
 * USER_MASTER repository
 * @author sugou
 *
 */
public interface UserMasterRepository {
	
	/**
	 * ユーザID/パスワードの存在チェック
	 *
	 * @param userMasterCondition  USER_MASTER sql条件  
	 * @return レコード数
	 */
	public int checkLogin(UserMasterCondition userMasterCondition) ;

	/**
	 * ユーザ情報取得
	 *
	 * @param userMasterCondition  USER_MASTER sql条件クラス
	 * @return ユーザ情報
	 */
	public UserMaster selectUser(UserMasterCondition userMasterCondition) ;
	
	/**
	 * ログイン情報更新(失敗)
	 *
	 * @param userMasterCondition  USER_MASTER sql条件クラス
	 */
	public void updateLoginFailure(UserMasterCondition userMasterCondition) ;
	
	/**
	 * ログイン情報更新(成功)
	 *
	 * @param userMasterCondition  USER_MASTER sql条件クラス
	 */
	public void updateLoginSuccess(UserMasterCondition userMasterCondition) ;

}
