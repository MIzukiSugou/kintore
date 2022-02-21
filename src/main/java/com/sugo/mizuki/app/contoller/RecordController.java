package com.sugo.mizuki.app.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sugo.mizuki.app.form.RecordForm;

/**
 * 記録画面コントローラークラス
 * @author sugou
 *
 */
@Controller
@RequestMapping(value = "/record")
public class RecordController {
	
	@ModelAttribute
	public RecordForm setUpForm() {
		RecordForm form = new RecordForm();
		return form;
	}
	/**
	 * 記録画面表示処理
	 * 
	 * @param model
	 * @return 記録画面
	 */
	@RequestMapping(value = "/access", method = { RequestMethod.GET, RequestMethod.POST })
	public String init(Model model) {

		return "record";
	}
}
