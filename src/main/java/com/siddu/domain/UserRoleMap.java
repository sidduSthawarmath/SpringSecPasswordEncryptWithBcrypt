package com.siddu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role_map")
public class UserRoleMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pkId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	AppUserDetails userDetails;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	Role role;

	public Integer getPkId() {
		return pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public AppUserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(AppUserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
