package com.abc.inviteuser.service;

import com.abc.inviteuser.dto.InviteCodeDTO;
import com.abc.inviteuser.exceptions.CustomInviteException;

public interface IInviteCodeService {
	
	InviteCodeDTO postInviteCode(Long wooId) throws CustomInviteException;
	
	InviteCodeDTO getInviteCode(Long wooId) throws CustomInviteException;
	
}
