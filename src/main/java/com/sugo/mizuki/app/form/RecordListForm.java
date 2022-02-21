package com.sugo.mizuki.app.form;

import java.io.Serializable;
import java.util.Map;

/**
 * 記録画面 フォーム「子」
 * @author sugou
 *
 */
public class RecordListForm implements Serializable{
	private static final long serialVersionUID = -6927939434355858350L;
	
	//更新時：削除フラグ
	private String deleteFlg;
	
	//筋トレメニューリスト(プルダウン)
	private Map<String, String> menuMap;
	
	//筋トレメニュー
	private String menu;
	
	//筋トレメニューキー
	private String menuKey;
	
	//重量
	private int weight;
	
	//セット1
	private int st1;
	
	//セット2
	private int st2;
	
	//セット3
	private int st3;	
	
	//セット4
	private int st4;	
	
	//セット5
	private int st5;
	
	//セット6
	private int st6;
	
	//合計
	private int sum;

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public Map<String, String> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<String, String> menuMap) {
		this.menuMap = menuMap;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSt1() {
		return st1;
	}

	public void setSt1(int st1) {
		this.st1 = st1;
	}

	public int getSt2() {
		return st2;
	}

	public void setSt2(int st2) {
		this.st2 = st2;
	}

	public int getSt3() {
		return st3;
	}

	public void setSt3(int st3) {
		this.st3 = st3;
	}

	public int getSt4() {
		return st4;
	}

	public void setSt4(int st4) {
		this.st4 = st4;
	}

	public int getSt5() {
		return st5;
	}

	public void setSt5(int st5) {
		this.st5 = st5;
	}

	public int getSt6() {
		return st6;
	}

	public void setSt6(int st6) {
		this.st6 = st6;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
