package com.abc.inviteuser.memory.db;

import java.util.HashMap;

import com.abc.inviteuser.entity.InviteCode;
import com.abc.inviteuser.entity.User;

public class InMemoryDatabase {

	public static HashMap<Long, User> userRepository = new HashMap<Long,User>();
	
	public static HashMap<Long, InviteCode> inviteCodeRepository = new HashMap<Long, InviteCode>();
	
	
	/*public void getMemoryInstance(){
		
		if(userRepository==null && inviteCodeRepository==null){
			this.userRepository = new HashMap<Long,User>();
			this.inviteCodeRepository = new HashMap<Long, InviteCode>();
		}
	}
	
	
	private InMemoryDatabase(){
		
	}*/
	
	
	
}
