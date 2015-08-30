package org.ship.core.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.ship.core.service.IUserInfoService;
import org.ship.persist.dao.IUserInfoDao;
import org.ship.persist.model.RoleInfo;
import org.ship.persist.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Resource
	private IUserInfoDao userInfoDao;
	
	public UserInfo getUserByCode(String userCode) {
		// TODO Auto-generated method stub
		return userInfoDao.getByHQL("from UserInfo where userCode = ?", userCode);
	}

	public List<String> loadUserAuthoritiesByCode(String userCode) {
		// TODO Auto-generated method stub
		UserInfo user = this.getUserByCode(userCode);
		if(user != null){
			Set<RoleInfo> roles = user.getRoles();
			List<String> auth = new ArrayList<String>();
			Iterator<RoleInfo> it = roles.iterator();
			while(it.hasNext()){
				auth.add(((RoleInfo)it.next()).getRoleName());
			}
			return auth;
		} else {
			return null;
		}
	}

}
