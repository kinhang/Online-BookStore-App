//package com.bookstore.domain.security;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
//import com.bookstore.domain.User;
//@Entity
//@Table(name="user_role")
//// intermediate table between user and role (many to many)
//public class UserRole implements Serializable{
//	private static final long serialVersionUID = 890345L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)//automatically generate id, increment one by one
//	private long userRoleId;
//	
//	public UserRole(){}
//	
//	public UserRole (User user, Role role){
//		this.user = user;
//		this.role = role;
//	}
//	
//	@ManyToOne(fetch = FetchType.EAGER)// when system try to retrieve the record from one of the table 
//	// one to many:Lazy(not save in memory, used in session); many to one: Eager (save in memory, used both in session and out of session)
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Role role;
//
//	public long getUserRoleId() {
//		return userRoleId;
//	}
//
//	public void setUserRoleId(long userRoleId) {
//		this.userRoleId = userRoleId;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	
//}

package com.bookstore.domain.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bookstore.domain.User;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 890345L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;
	
	public UserRole () {}
	
	public UserRole (User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

