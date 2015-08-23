package com.abc.inviteuser.tests;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Months;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.abc.inviteuser.dto.InviteCodeDTO;
import com.abc.inviteuser.dto.UserDTO;
import com.abc.inviteuser.entity.User;
import com.abc.inviteuser.exceptions.CustomInviteException;
import com.abc.inviteuser.repository.IInviteCodeRepository;
import com.abc.inviteuser.repository.IUserRepository;
import com.abc.inviteuser.repository.impl.InviteCodeRepositoryImpl;
import com.abc.inviteuser.repository.impl.UserRepositoryImpl;
import com.abc.inviteuser.service.impl.InviteCodeService;
import com.abc.inviteuser.service.impl.UserService;

public class Main {

		private static IInviteCodeRepository inviteCodeRepository; 
		private static IUserRepository userRepository;
		
		public static void preProcess(){
			inviteCodeRepository = new InviteCodeRepositoryImpl();
			userRepository = new UserRepositoryImpl();
		}
	
	    public static void main(String[] sm) throws CustomInviteException {
	    	preProcess();
	    	UserService userService = new UserService();
	    	userService.setUserRepository(userRepository);
	    	UserDTO userDto1 = userService.postUserEntry(3880007L, null);
	    	UserDTO userDto2 = userService.postUserEntry(3880008L, null);
	    	System.out.println(userService.getUserChilders(3880007L));
	    }
	    
	    public static void inviteCodeTest() throws CustomInviteException{
	    	
	    	InviteCodeService inviteCodeService = new InviteCodeService();
	        inviteCodeService.setCodeRepository(inviteCodeRepository);
	        InviteCodeDTO inviteCodeDto = inviteCodeService.postInviteCode(3880007L);
	        System.out.println(inviteCodeDto.getValidityDate());
	        System.out.println(inviteCodeService.postInviteCode(3880007L).getValidityDate());
	    }
	    
	    
	    public static void testJoda(){
	    	DateTimeFormatter dateFormat = DateTimeFormat
	                .forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

	        String dob = "2002-01-15";
	        LocalTime localTime = new LocalTime();
	        LocalDate localDate = new LocalDate();
	        DateTime dateTime = new DateTime();
	        LocalDateTime localDateTime = new LocalDateTime();
	        DateTimeZone dateTimeZone = DateTimeZone.getDefault();

	        System.out
	                .println("dateFormatr : " + dateFormat.print(localDateTime));
	        System.out.println("LocalTime : " + localTime.toString());
	        System.out.println("localDate : " + localDate.toString());
	        System.out.println("dateTime : " + dateTime.toString());
	        System.out.println("localDateTime : " + localDateTime.toString());
	        System.out.println("DateTimeZone : " + dateTimeZone.toString());
	        System.out.println("Year Difference : "
	                + Years.yearsBetween(DateTime.parse(dob), dateTime).getYears());
	        System.out.println("Month Difference : "
	                + Months.monthsBetween(DateTime.parse(dob), dateTime)
	                        .getMonths());
	    }

	
}
