package com.abc.inviteuser.repository.impl;

import java.util.List;

import com.abc.inviteuser.entity.User;
import com.abc.inviteuser.memory.db.InMemoryDatabase;
import com.abc.inviteuser.repository.IInviteCodeRepository;
import com.abc.inviteuser.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository{

	public IUserRepository saveUser(User user) {
		return null;
	}

	public IInviteCodeRepository findInviteCode(User user) {
		return null;
	}

	public IInviteCodeRepository finInviteCode(long wooId) {
		return null;
	}

	public List<User> findUserByWooId(long wooId) {
		
		//InMemoryDatabase.userRepository.put(wooId,);
		return null;
	}

}
