package com.sugo.mizuki.app.form;

import java.io.Serializable;
import java.util.List;

/**
 * 記録画面 フォーム「親」
 * @author sugou
 *
 */
public class RecordForm implements Serializable{
	private static final long serialVersionUID = -6927939434355858350L;
	
	//ユーザーId
	private String userId;
	
	//トレーニング記録　フォーム「子」
	private List<RecordListForm> recordList;
	
	//年月日(yyyy-MM-dd)
	private String dateView;
	
	//年月日(yyyymmdd)
	private String date;
	
	//TrainingMenu:value
	private String menu;
	
	//TrainingMenu:key
	private String menuKey;
	
	//記録ボタン制御
	private String recordBtnControl;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RecordListForm> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<RecordListForm> recordList) {
		this.recordList = recordList;
	}

	public String getDateView() {
		return dateView;
	}

	public void setDateView(String dateView) {
		this.dateView = dateView;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getRecordBtnControl() {
		return recordBtnControl;
	}

	public void setRecordBtnControl(String recordBtnControl) {
		this.recordBtnControl = recordBtnControl;
	}
	
}
