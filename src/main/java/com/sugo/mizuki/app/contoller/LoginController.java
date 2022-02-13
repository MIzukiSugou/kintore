package com.sugo.mizuki.app.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ログイン画面コントローラークラス
 * @author sugou
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


	/**
	 * ログイン画面表示処理
	 * 
	 * @param model
	 * @return 画面
	 */
	@RequestMapping(value = "/access", method = { RequestMethod.GET, RequestMethod.POST })
	public String getLogin(Model model) {

		return "/login";
	}

}
