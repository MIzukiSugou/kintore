package com.sugo.mizuki.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sugo.mizuki.domain.condition.UserMasterCondition;
import com.sugo.mizuki.domain.model.UserMaster;

/**
 * USER_MASTER repository
 * @author sugou
 *
 */
@Repository
public class UserMasterRepositoryImpl implements UserMasterRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * ユーザID/パスワードの存在チェック
	 *
	 * @param userMasterCondition  USER_MASTER sql条件  
	 * @return レコード数
	 */
	@Override
	public int checkLogin(UserMasterCondition userMasterCondition) {
		String sql = "SELECT"
				+ "       COUNT(1) RECORD_COUNT "
				+ "FROM"
				+ "       USER_MASTER UMT "
				+ "       ,PASSWORD_MANAGEMENT PMT "
				+ "WHERE"
				+ "       UMT.USER_ID = :userId "
				+ "AND UMT.ACCOUNT_LOCK_FLAG = :accountLockFlagOff "
				+ "AND UMT.DELETE_FLAG = :deleteFlagOff "
				+ "AND UMT.USER_ID = PMT.USER_ID "
				+ "AND PMT.PASSWORD = :password "
				+ "AND PMT.DELETE_FLAG  = :deleteFlagOff "
				+ "AND PMT.CHANGE_COUNT = "
				+ "  (SELECT"
				+ "        MAX(CHANGE_COUNT) "
				+ "FROM"
				+ "        PASSWORD_MANAGEMENT "
				+ "WHERE"
				+ "        USER_ID = :userId "
				+ "AND DELETE_FLAG = :deleteFlagOff) ";
		//sql条件
		MapSqlParameterSource map = new MapSqlParameterSource()
		.addValue("userId",userMasterCondition.getUserId())                              //ユーザーID 
		.addValue("accountLockFlagOff",userMasterCondition.getAccountLockFlagOff()) //アカウントロックフラグ(0:OFF)
		.addValue("password",userMasterCondition.getPassword())                      //パスワード
		.addValue("deleteFlagOff",userMasterCondition.getDeleteFlagOff());                 // 削除フラグ(0:OFF)

		int count = namedParameterJdbcTemplate.queryForObject(sql,map,int.class);

		return count;
	}

	/**
	 * ユーザ情報取得
	 *
	 * @param userMasterCondition  USER_MASTER sql条件  
	 * @return ユーザ情報
	 */
	@Override
	public UserMaster selectUser(UserMasterCondition userMasterCondition) {
		String sql = "SELECT"
				+ "    USER_ID"
				+ "    , LAST_NM"
				+ "    , FIRST_NM "
				+ "FROM"
				+ "    USER_MASTER "
				+ "WHERE"
				+ "    USER_ID = :userId"
				+ "    AND DELETE_FLAG = :deleteFlagOff";
		
		//sql条件
		MapSqlParameterSource map = new MapSqlParameterSource()
		.addValue("userId",userMasterCondition.getUserId())                       //ユーザーID 
		.addValue("deleteFlagOff",userMasterCondition.getDeleteFlagOff());          // 削除フラグ(0:OFF)
		
		Map<String, Object> result = namedParameterJdbcTemplate.queryForMap(sql, map);

		UserMaster userMaster= new UserMaster();
		userMaster.setUserId((String) result.get("USER_ID"));
		userMaster.setFirstName((String) result.get("FIRST_NM"));
		userMaster.setLastName((String) result.get("LAST_NM"));

		return userMaster;
	}

	/**
	 * ログイン情報更新(失敗)
	 *
	 * @param userMasterCondition  USER_MASTER sql条件  
	 */
	@Override
	public void updateLoginFailure(UserMasterCondition userMasterCondition) {
		String sql = "UPDATE USER_MASTER "
				+ "SET"
				+ "    LOGIN_FAILURE_COUNT = CASE "
				+ "        WHEN LOGIN_FAILURE_COUNT IS NULL "
				+ "            THEN :loginFailureCount"
				+ "        ELSE (LOGIN_FAILURE_COUNT + :loginFailureCount) "
				+ "        END"
				+ "    , ACCOUNT_LOCK_FLAG = CASE "
				+ "        WHEN ( "
				+ "            LOGIN_FAILURE_COUNT IS NOT NULL "
				+ "            AND (LOGIN_FAILURE_COUNT + :loginFailureCount) >= :loginFailureMaxCount"
				+ "        ) "
				+ "            THEN :accountLockFlagOn "
				+ "        ELSE :accountLockFlagOff "
				+ "        END"
				+ "    , UPDATE_DATE = NOW()"
				+ "    , UPDATE_USER = :userId "
				+ "WHERE"
				+ "    USER_ID = :userId "
				+ "    AND DELETE_FLAG = :deleteFlagOff";
		
		//sql条件
		MapSqlParameterSource map = new MapSqlParameterSource()
		.addValue("loginFailureCount",userMasterCondition.getLoginFailureCount())                //ログイン失敗回数 
		.addValue("loginFailureMaxCount",userMasterCondition.getLoginFailureMaxCount())    //ログイン失敗最大回数
		.addValue("accountLockFlagOn",userMasterCondition.getAccountLockFlagOn())           //アカウントロックフラグ(1:ON)
		.addValue("accountLockFlagOff",userMasterCondition.getAccountLockFlagOff())          //アカウントロックフラグ(1:OFF)
		.addValue("userId",userMasterCondition.getUserId())                                               //ユーザーID
		.addValue("deleteFlagOff",userMasterCondition.getDeleteFlagOff()) ;                           //削除(0:OFF)
		
		namedParameterJdbcTemplate.update(sql,map);
	}

	/**
	 * ログイン情報更新(成功)
	 *
	 * @param userMasterCondition  USER_MASTER sql条件  
	 */
	@Override
	public void updateLoginSuccess(UserMasterCondition userMasterCondition) {
		String sql = "UPDATE USER_MASTER "
				+ "SET"
				+ "    LAST_LOGIN_DATE = NOW()"
				+ "    , LOGIN_COUNT = ( "
				+ "        CASE "
				+ "            WHEN LOGIN_COUNT IS NULL "
				+ "                THEN :loginCount "
				+ "            ELSE LOGIN_COUNT + :loginCount "
				+ "            END"
				+ "    ) "
				+ "    , LOGIN_FAILURE_COUNT = :loginFailureCount"
				+ "    , UPDATE_DATE = NOW()"
				+ "    , UPDATE_USER = :userId "
				+ "WHERE"
				+ "    USER_ID = :userId "
				+ "    AND DELETE_FLAG = :deleteFlagOff";
		
		//sql条件
		MapSqlParameterSource map = new MapSqlParameterSource()
		.addValue("loginCount",userMasterCondition.getLoginCount())                                  //ログイン回数
		.addValue("loginFailureCount",userMasterCondition.getLoginFailureCount())                //ログイン失敗回数 
		.addValue("userId",userMasterCondition.getUserId())                                               //ユーザーID
		.addValue("deleteFlagOff",userMasterCondition.getDeleteFlagOff()) ;                           //削除(0:OFF)
		
		namedParameterJdbcTemplate.update(sql,map);
	}

}
