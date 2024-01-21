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

import com.example.share.dto.UserResponseDTO;
import com.example.share.entities.Role;
import com.example.share.enums.Roles;
import com.example.share.mapper.UserResponseMapper;
import com.example.share.repositories.UserRepository;

import lombok.Getter;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Getter
	private Optional<com.example.share.entities.User> EUser;
	
	@Autowired
	UserResponseMapper userResponseMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		EUser=userRepository.findByEmailOrUserName(username,username);
		if(EUser.isPresent()) {
			UserDetailsImpl userDetailsImpl=new UserDetailsImpl(EUser.get().getEmail(), EUser.get().getPassword(), EUser.get().getRoles().stream().map(Role::getIntitule).collect(Collectors.toSet()));
			User user=new User(EUser.get().getEmail(), EUser.get().getPassword(),userDetailsImpl.getAuthorities());
			return user;
		}
		throw new UsernameNotFoundException("utilisateur ou password incorrect.");

	}
	
	public UserResponseDTO convertirUserToDTO() {
		return EUser.isPresent()?userResponseMapper.EntityToDto(EUser.get()):null;
	}

}
