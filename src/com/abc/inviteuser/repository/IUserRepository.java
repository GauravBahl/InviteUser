package com.abc.inviteuser.repository;

import java.util.List;

import com.abc.inviteuser.entity.User;

public interface IUserRepository {
	
	IUserRepository saveUser(User user);
	
	IInviteCodeRepository findInviteCode(User user);
	
	IInviteCodeRepository finInviteCode(long wooId);
	
	List<User> findUserByWooId(long wooId);
	
}
