package com.example.share.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.share.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

	Role findByLibelle(String libelle);
	
}
