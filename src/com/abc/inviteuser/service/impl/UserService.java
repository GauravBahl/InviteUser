package com.abc.inviteuser.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.abc.inviteuser.dto.UserDTO;
import com.abc.inviteuser.entity.User;
import com.abc.inviteuser.exceptions.CustomInviteException;
import com.abc.inviteuser.repository.IUserRepository;
import com.abc.inviteuser.service.IUserService;

public class UserService implements IUserService{
	
	private IUserRepository userRepository;

	public UserDTO postUserEntry(Long wooId, List<User> childerns) throws CustomInviteException{
		
		List<User> existinguser = userRepository.findUserByWooId(wooId);
		UserDTO userDtoList = null;
		if(existinguser==null){
			//User doesn't exist
			User newUser = new User();
			newUser.setWooId(wooId);
			if(childerns!=null){
				Iterator<User> it = childerns.iterator();
				List<User> childrens = new ArrayList<User>();
				while(it.hasNext()){
					User child = it.next();
					childrens.add(child);
				}
				newUser.setChildrens(childrens);
			}
			
			try {
				userDtoList = new UserDTO();
				BeanUtils.copyProperties(userDtoList, newUser);
			}catch(Exception e){
				throw new CustomInviteException(e);
			}
		}else{
			//User already exists
			if(childerns!=null){
				Iterator<User> it = childerns.iterator();
				List<User> childrens = new ArrayList<User>();
				while(it.hasNext()){
					User child = it.next();
					childerns.add(child);
				}
				existinguser.addAll(childrens);
			}
			
			try{
				userDtoList = new UserDTO();
				BeanUtils.copyProperties(userDtoList, existinguser);
			}catch(Exception e){
				throw new CustomInviteException(e);
			}
		}
		
		return userDtoList;
	}
	
	
	public List<UserDTO> getUserChilders(Long wooId) throws CustomInviteException{
		
		List<User> userList  =  userRepository.findUserByWooId(wooId);
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		try {
			BeanUtils.copyProperties(userDTOList, userList);
		}catch(Exception e){
			throw new CustomInviteException(e);
		}
		
		return userDTOList;
	}
	
	public IUserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
