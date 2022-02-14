package com.sugo.mizuki.app.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sugo.mizuki.app.form.LoginForm;
import com.sugo.mizuki.domain.service.LoginService;

/**
 * ログイン画面コントローラークラス
 * @author sugou
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm form = new LoginForm();
		return form;
	}

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
	
	/**
	 * ログインボタン押下時の処理
	 * 
	 * @param form ログインフォーム
	 * @param result  バリデーションエラー情報
	 * @param model モデル情報
	 * @param redirectAttridutes
	 * @param session セッション情報
	 * @return ログイン画面/メニュー画面
	 */
	@RequestMapping(value = "/execution", method = RequestMethod.POST)
	public String login(@Validated LoginForm form, BindingResult result, Model model,
			RedirectAttributes redirectAttridutes, HttpSession session) {

		// 入力チェック
		if (result.hasErrors()) {
			// 入力エラーの場合
			return "/login";
		}

		//ログインID存在チェック
		if (!loginService.checkInput(form)) {
			//存在しない場合
			return "/login";
		} else {
			//存在した場合
			// ログイン処理実行
			if (loginService.executeLogin(form, session)) {
				// 取得成功の場合
				return "/test";
				//return "forward:/calendarrecord/access";
			} else {
				// 取得エラーの場合
				return "/login";
			}
		}
	}
}
