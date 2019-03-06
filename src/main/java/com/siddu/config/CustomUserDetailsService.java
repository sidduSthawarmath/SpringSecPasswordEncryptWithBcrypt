package com.siddu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.siddu.dao.service.AppUserDetailsService;
import com.siddu.domain.AppUserDetails;
import com.siddu.domain.UserRoleMap;
@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		AppUserDetails appUser = appUserDetailsService.findByUserName(userName);
		System.out.println("User : " + appUser);
		if (appUser == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(appUser.getUserName(), appUser.getPassword(),
				true, true, true, true, getGrantedAuthorities(appUser));
	}

	private java.util.List<GrantedAuthority> getGrantedAuthorities(AppUserDetails user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UserRoleMap userRoleMap = appUserDetailsService.findUserRoleMapByUserPkId(user.getPkId());
		authorities.add(new SimpleGrantedAuthority("ROLE_" + userRoleMap.getRole().getRoleCode()));
		System.out.print("authorities :" + authorities);
		return authorities;
	}
}
