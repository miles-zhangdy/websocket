package com.ssm.common.exception;


public class MyException extends Exception {

	private static final long serialVersionUID = -5848136523986089561L;
	
	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
	}

	public MyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

}
