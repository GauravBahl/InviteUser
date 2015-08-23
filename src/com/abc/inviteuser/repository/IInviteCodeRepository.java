package com.abc.inviteuser.repository;

import java.util.Collection;

import com.abc.inviteuser.entity.InviteCode;

public interface IInviteCodeRepository {
	
	InviteCode save(InviteCode inviteCodes);
	
	InviteCode findById(long wooId);
	
	InviteCode update(long wooId);
	
	Collection<InviteCode> findAll();

}
