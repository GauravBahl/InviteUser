package com.abc.inviteuser.exceptions;



public class CustomInviteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8872095120951662171L;
	
	private ExceptionCategory exceptionCategory;
	
	public CustomInviteException(){
		super();
	}
	
	
	public CustomInviteException(String message , Throwable cause, boolean enableException, boolean writeStackTrace){
		super(message, cause, enableException, writeStackTrace);
	}
	
	public CustomInviteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomInviteException(String message) {
		super(message);
	}

	public CustomInviteException(Throwable cause) {
		super(cause);
	}

	public ExceptionCategory getErrorCategory() {
		return exceptionCategory;
	}

	public void setErrorCategory(ExceptionCategory errorCategory) {
		this.exceptionCategory = errorCategory;
	}

}
