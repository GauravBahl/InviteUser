package com.abc.inviteuser.repository.impl;

import java.util.Collection;

import com.abc.inviteuser.entity.InviteCode;
import com.abc.inviteuser.entity.User;
import com.abc.inviteuser.memory.db.InMemoryDatabase;
import com.abc.inviteuser.repository.IInviteCodeRepository;
import com.abc.inviteuser.repository.IUserRepository;

public class InviteCodeRepositoryImpl implements IInviteCodeRepository{

	public InviteCode save(InviteCode inviteCodes) {
		Long wooId = inviteCodes.getWooId();
		InviteCode invCode = InMemoryDatabase.inviteCodeRepository.get(wooId);
		String inviteCodeValue = null;
		if(invCode!=null){
			inviteCodeValue = invCode.getCode();
		}
		 
		if(inviteCodeValue==null){
			InMemoryDatabase.inviteCodeRepository.put(wooId, inviteCodes);
			inviteCodeValue = InMemoryDatabase.inviteCodeRepository.get(wooId).getCode();
		}
		return inviteCodes;
	}

	public InviteCode findById(long wooId) {
		InviteCode inviteCodeObj = InMemoryDatabase.inviteCodeRepository.get(wooId);
		return inviteCodeObj;
	}

	


	public Collection<InviteCode> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public InviteCode update(long wooId) {
		// TODO Auto-generated method stub
		return null;
	}

}
