package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name);
}
