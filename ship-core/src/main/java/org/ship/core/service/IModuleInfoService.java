package org.ship.core.service;

import java.util.List;

import org.ship.persist.model.ModuleInfo;

public interface IModuleInfoService {

	public List<ModuleInfo> findModuleInfoByUri(String requestUri);
	
	public List<ModuleInfo> findModuleInfoByAll();
}
