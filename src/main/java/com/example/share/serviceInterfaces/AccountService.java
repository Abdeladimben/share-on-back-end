package com.example.share.serviceInterfaces;

import com.example.share.dto.AccountLoginDTO;
import com.example.share.dto.AccountRequestDTO;
import com.example.share.dto.AccountResponseDTO;
import com.example.share.dto.AccountWithoutRoleDTO;
import com.example.share.dto.UpdatePasswordDTO;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.exception.GeneralException;
import com.example.share.helpers.LoginResponse;

public interface AccountService {
	
	public LoginResponse login(AccountLoginDTO accountLoginDTO);
	
	public AccountRequestDTO create(AccountWithoutRoleDTO accountWithoutRoleDTO) throws EmailAlreadyExistsException;
	
	public AccountRequestDTO updatePassword(UpdatePasswordDTO updatePasswordDTO) throws EmailAlreadyExistsException, GeneralException;
	
}
