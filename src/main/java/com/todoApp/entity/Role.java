package com.todoApp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLES_TBL")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}
