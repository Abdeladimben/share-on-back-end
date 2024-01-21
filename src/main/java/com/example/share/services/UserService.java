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
import com.example.share.dto.UserLoginDTO;
import com.example.share.dto.UserRequestDTO;
import com.example.share.dto.UserResponseDTO;
import com.example.share.dto.UserWithoutRoleDTO;
import com.example.share.dto.UpdatePasswordDTO;
import com.example.share.entities.User;
import com.example.share.entities.Role;
import com.example.share.enums.ErrorCode;
import com.example.share.enums.Roles;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.exception.GeneralException;
import com.example.share.exception.TokenIsExpiredException;
import com.example.share.exception.TokenIsNotValidException;
import com.example.share.helpers.LoginResponse;
import com.example.share.mapper.UserRequestMapper;
import com.example.share.mapper.UserWithoutRoleMapper;
import com.example.share.repositories.UserRepository;

import antlr.Token;

import com.example.share.repositories.RoleRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserWithoutRoleMapper userWithoutRoleMapper;
	
	@Autowired
	UserRequestMapper userRequestMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public LoginResponse login(UserLoginDTO userLoginDTO) {
		// TODO Auto-generated method stub
		Optional<UserDetails> user =Optional.ofNullable(userDetailServiceImpl.loadUserByUsername(userLoginDTO.getEmail())) ;
		if(user.isPresent()) {
			UserResponseDTO userResponseDTO=userDetailServiceImpl.convertirUserToDTO();
			Set<GrantedAuthority> authorities=new HashSet<>();
			userResponseDTO.getRoles().stream().forEach(role->{
				authorities.add(new SimpleGrantedAuthority(role.getIntitule().toString()));
			});
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							userLoginDTO.getEmail(),
							userLoginDTO.getPassword(),
							authorities
					)
			);
			return new LoginResponse(jwtUtil.generateToken(user.get()),userResponseDTO);
		}else {
			throw new UsernameNotFoundException("User not found");
		}

	}

	@Override
	public UserRequestDTO create(UserWithoutRoleDTO userWithoutRoleDTO) throws EmailAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByEmail(userWithoutRoleDTO.getEmail());
		if (!user.isPresent()) {
			User userToAdd=userWithoutRoleMapper.DtotoEntity(userWithoutRoleDTO);
			userToAdd.setPassword(passwordEncoder.encode(userToAdd.getPassword()));
			Role role=roleRepository.findByLibelle(Roles.ROLE_USER.toString());
			Set<Role> setRoles = new HashSet<>();
			setRoles.add(role);
			userToAdd.setRoles(setRoles);
			userRepository.save(userToAdd);
			UserRequestDTO userReturned = userRequestMapper.EntityToDto(userToAdd);
			return userReturned;
		}else {
			throw new EmailAlreadyExistsException(ErrorCode.AE100.getMessage(),ErrorCode.AE100,HttpStatus.CONFLICT);
		}
		
		
	}

	@Override
	public UserRequestDTO updatePassword(UpdatePasswordDTO updatePasswordDTO) throws EmailAlreadyExistsException, GeneralException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByEmail(updatePasswordDTO.getEmail())
				.orElseThrow(()-> new EmailAlreadyExistsException(ErrorCode.AE100.getMessage(),ErrorCode.AE100,HttpStatus.CONFLICT));
		
		if( !passwordEncoder.matches(updatePasswordDTO.getPassword(), user.getPassword()) || 
			!updatePasswordDTO.getConfirmPassword().equals(updatePasswordDTO.getNouveauPassword())
		)
			throw new GeneralException(ErrorCode.U003.getMessage(),ErrorCode.U003,HttpStatus.BAD_REQUEST);
		
		user.setPassword(passwordEncoder.encode(updatePasswordDTO.getNouveauPassword()));
		User userUpdated= userRepository.save(user);
		UserRequestDTO userReturned = userRequestMapper.EntityToDto(userUpdated);
		return userReturned;
	}

	@Override
	public UserRequestDTO info(String accessToken) throws TokenIsExpiredException, TokenIsNotValidException {
		// TODO Auto-generated method stub
		if(jwtUtil.isTokenExpired(accessToken)) {
			throw new TokenIsExpiredException(ErrorCode.T002);
		}
		String email = jwtUtil.extractUserEmail(accessToken);
		Optional<User> oUser = userRepository.findByEmailOrUserName(email, email);
		User user = oUser.orElseThrow(() -> new TokenIsNotValidException(ErrorCode.T001));
		UserRequestDTO userReturned = userRequestMapper.EntityToDto(user);
		return userReturned;
	}

}
