package org.ship.core.service;

import java.util.List;

import org.ship.persist.model.UserInfo;

public interface IUserInfoService {
	
	public UserInfo getUserByCode(String userCode);
	
	public List<String> loadUserAuthoritiesByCode(String userCode);
}
