package com.pharmacy.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DTLS_TBL_OPM")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "USER_NAME")
	private String name;
	@Column(name = "USER_EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CONTACT")
	private Long contact;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES_OPM", joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", nullable = false) })
	private List<Role> roles = new ArrayList<>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", contact=" + contact + ", roles=" + roles + "]";
	}

}
