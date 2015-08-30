package org.ship.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ship.core.service.IRoleInfoService;
import org.ship.persist.dao.IRoleInfoDao;
import org.ship.persist.model.RoleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleInfoService")
public class RoleInfoServiceImpl implements IRoleInfoService{

	@Resource
	private IRoleInfoDao roleInfoDao;
	
	public List<RoleInfo> queryByAll() {
		// TODO Auto-generated method stub
		return roleInfoDao.getListByHQL("from RoleInfo");
	}


}
