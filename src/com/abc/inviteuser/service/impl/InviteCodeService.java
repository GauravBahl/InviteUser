package com.abc.inviteuser.service.impl;

import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;

import com.abc.inviteuser.dto.InviteCodeDTO;
import com.abc.inviteuser.entity.InviteCode;
import com.abc.inviteuser.exceptions.CustomInviteException;
import com.abc.inviteuser.repository.IInviteCodeRepository;
import com.abc.inviteuser.repository.IUserRepository;
import com.abc.inviteuser.service.IInviteCodeService;

public class InviteCodeService implements IInviteCodeService{
	
	private int defaultLifeOfACode = 3;
	private int delayTime = 7;
	
	private IInviteCodeRepository codeRepository;
	
	private IUserRepository userRepository;
	
	public InviteCodeDTO postInviteCode(Long wooId) throws CustomInviteException {
		
		InviteCode inviteCode = null;
		inviteCode = codeRepository.findById(wooId);
		InviteCodeDTO inviteCodeDto = new InviteCodeDTO();
		//already exists
		if(inviteCode!=null){
			try{
				BeanUtils.copyProperties(inviteCodeDto,inviteCode);
			}catch(Exception e){
				throw new CustomInviteException(e);
			}
		}else{
			DateTime creationDateTime = new DateTime();
			DateTime validTillDT = creationDateTime.plusDays(defaultLifeOfACode);
			inviteCode = new InviteCode();
			//Somehow we will find how to store invite code ID
			inviteCode.setId(1L);
			inviteCode.setWooId(wooId);
			inviteCode.setCounter(0);
			inviteCode.setValidOrNot(true);
			inviteCode.setCreationDate(creationDateTime);
			inviteCode.setValidityDate(validTillDT);
			inviteCode.setLastUpdatedDate(null);
			inviteCode.setCode(inviteCodeGenerator(wooId));
			inviteCode = codeRepository.save(inviteCode);
			try {
				//inviteCodeDto = (InviteCodeDTO) BeanUtils.cloneBean(inviteCode);
				BeanUtils.copyProperties(inviteCodeDto,inviteCode);
			} catch(Exception e){
				throw new CustomInviteException(e);
			}
		}
		
		//System.out.println(inviteCode);
		
		return inviteCodeDto; 
	}

	
	private String inviteCodeGenerator(Long wooId){
		return jumble(String.valueOf(wooId).split(""));
	}
	
	private String jumble(String[] arr){
	    Random r = new Random();
	    for(int i = arr.length-1; i > 0; i--){
	        int rand = r.nextInt(i);
	        String temp = arr[i];
	        arr[i] = arr[rand];
	        arr[rand] = temp;
	    }
	    
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i]);
		}
	    return builder.toString();
	}
	
	public InviteCodeDTO getInviteCode(Long wooId) throws CustomInviteException {
		
		InviteCode inviteCode = codeRepository.findById(wooId);
		InviteCodeDTO inviteCodeDto = new InviteCodeDTO();
		
		try {
			BeanUtils.copyProperties(inviteCodeDto,inviteCode);
		}catch(Exception e){
			throw new CustomInviteException(e);
		}
		
		return inviteCodeDto;
	}

	
	public IInviteCodeRepository getCodeRepository() {
		return codeRepository;
	}


	public void setCodeRepository(IInviteCodeRepository codeRepository) {
		this.codeRepository = codeRepository;
	}


	public IUserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
