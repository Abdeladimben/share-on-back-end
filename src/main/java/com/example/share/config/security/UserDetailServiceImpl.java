package com.example.share.config.security;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.share.dto.AccountResponseDTO;
import com.example.share.entities.Account;
import com.example.share.entities.Role;
import com.example.share.enums.Roles;
import com.example.share.mapper.AccountResponseMapper;
import com.example.share.repositories.AccountRepository;

import lombok.Getter;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Getter
	private Optional<Account> account;
	
	@Autowired
	AccountResponseMapper accountResponseMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		account=accountRepository.findByEmail(username);
		if(account.isPresent()) {
			UserDetailsImpl userDetailsImpl=new UserDetailsImpl(account.get().getEmail(), account.get().getPassword(), account.get().getRoles().stream().map(Role::getNom).collect(Collectors.toSet()));
			User user=new User(account.get().getEmail(), account.get().getPassword(),userDetailsImpl.getAuthorities());
			return user;
		}
		throw new UsernameNotFoundException("Email Not Found");

	}
	
	public AccountResponseDTO convertirAccountToDTO() {
		return account.isPresent()?accountResponseMapper.EntityToDto(account.get()):null;
	}

}
