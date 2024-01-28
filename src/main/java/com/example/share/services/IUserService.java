package com.example.share.services;

import com.example.share.dto.UserLoginDTO;
import com.example.share.dto.UserRequestDTO;
import com.example.share.dto.UserResponseDTO;
import com.example.share.dto.UserWithoutRoleDTO;
import com.example.share.dto.UpdatePasswordDTO;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.exception.GeneralException;
import com.example.share.exception.PasswordIsNotValidException;
import com.example.share.exception.TokenIsExpiredException;
import com.example.share.exception.TokenIsNotValidException;
import com.example.share.helpers.LoginResponse;

public interface IUserService {
	
	public LoginResponse login(UserLoginDTO accountLoginDTO);
	
	public UserRequestDTO create(UserWithoutRoleDTO accountWithoutRoleDTO) throws EmailAlreadyExistsException, PasswordIsNotValidException;
	
	public UserRequestDTO updatePassword(UpdatePasswordDTO updatePasswordDTO) throws EmailAlreadyExistsException, GeneralException, PasswordIsNotValidException;

	public UserRequestDTO info(String accessToken) throws TokenIsExpiredException, TokenIsNotValidException;
	
}
