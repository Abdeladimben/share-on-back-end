package com.example.share.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.share.entities.Account;
import com.example.share.enums.Roles;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	public Optional<Account> findByUuid(String uuid);
	
	public Optional<Account> findByEmail(String email);
	
	public Optional<Account> findByEmailAndPassword(String email,String Password);
	
	public long countByRoles_libelle(String libelle);

}
