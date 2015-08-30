package org.ship.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.ship.core.service.IUserInfoService;
import org.ship.persist.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/root")
public class RootController {

	@Autowired
	private IUserInfoService userInfoService;
	
	@RequestMapping( value = "findByUserList", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> findByUserList(String userCode){
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo user = userInfoService.getUserByCode(userCode);
		map.put("user", user);
		return map;
	}

	@RequestMapping( value = "showHello", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> showHello(){
		Map<String, Object> map = new HashMap<String, Object>();
		String str = "Hello World!";
		map.put("String", str);
		return map;
	}
	
}
