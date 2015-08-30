package org.ship.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.ship.core.service.IModuleInfoService;
import org.ship.persist.model.ModuleInfo;
import org.ship.persist.model.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyInvocationSecurityMetadataSourceService 
	implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private IModuleInfoService moduleInfoService;
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String url = ((FilterInvocation) object).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1 ){
			url = url.substring(0, firstQuestionMarkIndex);
		}
		System.out.println("url:" + url);
		List<ConfigAttribute> result = new ArrayList<ConfigAttribute>();
		ConfigAttribute attribute = new SecurityConfig("ROLE_BASE");
		result.add(attribute);
		try {
			List<ModuleInfo> moduleList = moduleInfoService.findModuleInfoByUri(url);
			if (moduleList != null && moduleList.size() > 0){
				System.out.println("moduleNum:"+moduleList.size());
				for( ModuleInfo module : moduleList){
					System.out.println("moduleName:"+module.getModuleName());
					Set<RoleInfo> roles = module.getRoles();
					if(roles != null && roles.size() > 0) {
						System.out.println("RoleSize:"+roles.size());
						for(RoleInfo role : roles ){
							System.out.println("RoleName:"+role.getRoleName());
							ConfigAttribute conf = new SecurityConfig(
									role.getRoleName());
							result.add(conf);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
