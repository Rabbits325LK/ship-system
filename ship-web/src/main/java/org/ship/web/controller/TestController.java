package org.ship.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ship.core.service.IRoleInfoService;
import org.ship.persist.model.RoleInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {

	@Resource
	public IRoleInfoService roleInfoService;
	
	@RequestMapping( value="toLogin", method = RequestMethod.GET)
	public String toLoginPage(){
		
		return "/login";
	}
	
	@RequestMapping( value="roleQueryByAll" , produces="application/json;charset=UTF8")
	public @ResponseBody Map<String ,Object> roleQueryByAll(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<RoleInfo> role = roleInfoService.queryByAll();
		map.put("role", role);
		return map;
	}
}
