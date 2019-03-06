package com.siddu.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siddu.dao.service.AppUserDetailsService;
import com.siddu.domain.AppUserDetails;
import com.siddu.domain.UserRoleMap;

@Repository
@Transactional
public class AppUserDetailsDaoImpl implements AppUserDetailsService {

	@PersistenceContext
	EntityManager entityManager;

	public AppUserDetails findByUserName(String userName) {
		AppUserDetails appUserDetails=null;
		Query query = entityManager.createQuery("from AppUserDetails where userName='" + userName + "'");
		try {
		appUserDetails = (AppUserDetails) query.getSingleResult();
		}catch (Exception e) {
		}
		return appUserDetails;
		
	}

	public UserRoleMap findUserRoleMapByUserPkId(Integer pkId) {
		Query query = entityManager.createQuery("from UserRoleMap where userDetails.pkId='" + pkId + "'");
		UserRoleMap userRoleMap = (UserRoleMap) query.getSingleResult();
		return userRoleMap;
	}

}
