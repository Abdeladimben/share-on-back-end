package com.example.share.config;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.share.entities.Account;
import com.example.share.entities.Role;
import com.example.share.enums.Roles;
import com.example.share.repositories.AccountRepository;
import com.example.share.repositories.RoleRepository;

@Component
//@Profile("init")
public class DbInit {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	@PostConstruct
	private void postConstruct() throws Exception {
		long countRole = roleRepository.count();
		importRoles(countRole);
		long countUser = accountRepository.countByRoles_libelle(Roles.ROLE_ADMIN.toString());
		if(countUser==0)
			addAccountAdmin();

	}

	private void importRoles(long countRole) {
		if(countRole==0) {
			addRoleUser();
			addRoleAdmin();
		}else {
			List<Role> roles=roleRepository.findAll();
			boolean roleAdmin=roles.stream().map(Role::getNom).collect(Collectors.toList()).contains(Roles.ROLE_ADMIN);
			boolean roleUser=roles.stream().map(Role::getNom).collect(Collectors.toList()).contains(Roles.ROLE_USER);
			if(!roleAdmin) {
				addRoleAdmin();
			}else if(!roleUser) {
				addRoleUser();
			}
		}
	}
	
	private void addRoleAdmin() {
		Role role = new Role();
		role.setNom(Roles.ROLE_ADMIN);
		role.setLibelle(Roles.ROLE_ADMIN.toString());
		role = roleRepository.save(role);
	}
	
	private void addRoleUser() {
		Role role = new Role();
		role.setNom(Roles.ROLE_USER);
		role.setLibelle(Roles.ROLE_USER.toString());
		role = roleRepository.save(role);
	}
	
	private void addAccountAdmin() {
		Role role=roleRepository.findByLibelle(Roles.ROLE_ADMIN.toString());
		Account account=Account.builder()
				.email("admin@gmail.com")
				.nom("admin")
				.prenom("adminprenom")
				.password("123456")
				.roles(new HashSet<Role>(Arrays.asList(role)))
				.build();
		accountRepository.save(account);
	}

}
