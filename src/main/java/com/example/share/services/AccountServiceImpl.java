package com.example.share.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.share.config.security.JwtUtil;
import com.example.share.config.security.UserDetailServiceImpl;
import com.example.share.config.security.UserDetailsImpl;
import com.example.share.dto.AccountLoginDTO;
import com.example.share.dto.AccountRequestDTO;
import com.example.share.dto.AccountResponseDTO;
import com.example.share.dto.AccountWithoutRoleDTO;
import com.example.share.dto.UpdatePasswordDTO;
import com.example.share.entities.Account;
import com.example.share.entities.Role;
import com.example.share.enums.ErrorCode;
import com.example.share.enums.Roles;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.exception.GeneralException;
import com.example.share.helpers.LoginResponse;
import com.example.share.mapper.AccountRequestMapper;
import com.example.share.mapper.AccountWithoutRoleMapper;
import com.example.share.repositories.AccountRepository;
import com.example.share.repositories.RoleRepository;
import com.example.share.serviceInterfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AccountWithoutRoleMapper accountWithoutRoleMapper;
	
	@Autowired
	AccountRequestMapper accountRequestMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public LoginResponse login(AccountLoginDTO accountLoginDTO) {
		// TODO Auto-generated method stub
		
		Optional<UserDetails> user =Optional.ofNullable(userDetailServiceImpl.loadUserByUsername(accountLoginDTO.getEmail())) ;
		if(user.isPresent()) {
			AccountResponseDTO accountResponseDTO=userDetailServiceImpl.convertirAccountToDTO();
			Set<GrantedAuthority> authorities=new HashSet<>();
			accountResponseDTO.getRoles().stream().forEach(role->{
				authorities.add(new SimpleGrantedAuthority(role.getNom().toString()));
			});
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							accountLoginDTO.getEmail(),
							accountLoginDTO.getPassword(),
							authorities
					)
			);
			return new LoginResponse(jwtUtil.generateToken(user.get()),accountResponseDTO);
		}else {
			throw new UsernameNotFoundException("User not found");
		}

	}

	@Override
	public AccountRequestDTO create(AccountWithoutRoleDTO accountWithoutRoleDTO) throws EmailAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<Account> user = accountRepository.findByEmail(accountWithoutRoleDTO.getEmail());
		if (!user.isPresent()) {
			Account accountToAdd=accountWithoutRoleMapper.DtotoEntity(accountWithoutRoleDTO);
			accountToAdd.setPassword(passwordEncoder.encode(accountToAdd.getPassword()));
			Role role=roleRepository.findByLibelle(Roles.ROLE_USER.toString());
			Set<Role> setRoles = new HashSet<>();
			setRoles.add(role);
			accountToAdd.setRoles(setRoles);
			accountRepository.save(accountToAdd);
			AccountRequestDTO accountReturned = accountRequestMapper.EntityToDto(accountToAdd);
			return accountReturned;
		}else {
			throw new EmailAlreadyExistsException(ErrorCode.AE100.getMessage(),ErrorCode.AE100,HttpStatus.CONFLICT);
		}
		
		
	}

	@Override
	public AccountRequestDTO updatePassword(UpdatePasswordDTO updatePasswordDTO) throws EmailAlreadyExistsException, GeneralException {
		// TODO Auto-generated method stub
		
		Account user = accountRepository.findByEmail(updatePasswordDTO.getEmail())
				.orElseThrow(()-> new EmailAlreadyExistsException(ErrorCode.AE100.getMessage(),ErrorCode.AE100,HttpStatus.CONFLICT));
		
		if( !passwordEncoder.matches(updatePasswordDTO.getPassword(), user.getPassword()) || 
			!updatePasswordDTO.getConfirmPassword().equals(updatePasswordDTO.getNouveauPassword())
		)
			throw new GeneralException(ErrorCode.U003.getMessage(),ErrorCode.U003,HttpStatus.BAD_REQUEST);
		
		user.setPassword(passwordEncoder.encode(updatePasswordDTO.getNouveauPassword()));
		Account userUpdated= accountRepository.save(user);
		AccountRequestDTO accountReturned = accountRequestMapper.EntityToDto(userUpdated);
		return accountReturned;
	}

}
