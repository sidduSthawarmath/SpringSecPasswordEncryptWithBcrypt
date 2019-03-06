package com.siddu.dao.service;

import com.siddu.domain.AppUserDetails;
import com.siddu.domain.UserRoleMap;


public interface AppUserDetailsService {

	AppUserDetails findByUserName(String userName);

	UserRoleMap findUserRoleMapByUserPkId(Integer pkId);

	
	
}
