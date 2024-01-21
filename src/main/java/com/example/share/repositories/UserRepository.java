package com.example.share.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.share.entities.User;
import com.example.share.enums.Roles;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByUuid(String uuid);
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByEmailOrUserName(String email,String userName);
	
	public Optional<User> findByEmailAndPassword(String email,String Password);
	
	public long countByRoles_libelle(String libelle);

}
