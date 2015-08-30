package org.ship.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ship.core.service.IUserInfoService;
import org.ship.persist.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserInfoService userInfoService;
	
	@Override
	public UserDetails loadUserByUsername(String userCode)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> auths =
				new ArrayList<GrantedAuthority>();
		UserInfo user = new UserInfo();
		try {
			user = userInfoService.getUserByCode(userCode);
			System.out.println("userName:"+user.getUserName());
			List<String> authStr = userInfoService.loadUserAuthoritiesByCode(userCode);
			System.out.println("authStrNum:"+authStr.size());
			for( String authName : authStr ){
				SimpleGrantedAuthority authprity = 
						new SimpleGrantedAuthority(authName);
				System.out.println("AuthName:"+authName);
				auths.add(authprity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUserCode(), 
				user.getUserPwd(),
				true,
				true,
				true,
				true,
				auths);
	}

}
