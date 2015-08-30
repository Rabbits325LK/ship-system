package org.ship.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.ship.core.service.IModuleInfoService;
import org.ship.persist.dao.IModuleInfoDao;
import org.ship.persist.model.ModuleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Transactional
@Service("moduleInfoService")
public class ModuleInfoServiceImpl implements IModuleInfoService{

	@Resource
	private IModuleInfoDao moduleInfoDao;
	
	public List<ModuleInfo> findModuleInfoByUri(String requestUri) {
		// TODO Auto-generated method stub
		List<ModuleInfo> moduleList = moduleInfoDao.getListByHQL("from ModuleInfo");
		List<ModuleInfo> modules = new ArrayList<ModuleInfo>();
		for(ModuleInfo module : moduleList ){
			if(urlMatcher(module.getModuleStr(), requestUri)){
				modules.add(module);
			}
		}
		return modules; 
	}

	private boolean urlMatcher(String moduleStr, String requestUri){
		boolean isMatcher = false;
		PathMatcher matcher = new AntPathMatcher();
		isMatcher = matcher.match(moduleStr, requestUri);
		return isMatcher;
	}

	public List<ModuleInfo> findModuleInfoByAll() {
		// TODO Auto-generated method stub
		return moduleInfoDao.getListByHQL("from ModuleInfo");
	}
}
