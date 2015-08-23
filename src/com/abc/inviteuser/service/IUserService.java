package com.abc.inviteuser.service;

import java.util.List;

import com.abc.inviteuser.dto.UserDTO;
import com.abc.inviteuser.entity.User;
import com.abc.inviteuser.exceptions.CustomInviteException;

public interface IUserService {
	
	UserDTO postUserEntry(Long wooId, List<User> childerns) throws CustomInviteException;
	
	List<UserDTO> getUserChilders(Long wooId) throws CustomInviteException;

}
