package com.ssm.common.plugins.translate.error;


public class TranslateException extends RuntimeException {
	 
	private static final long serialVersionUID = 3163588373189537877L;
	private int errcode = -1;
	private String msg;

	public TranslateException(int errcode, String msg, Throwable e) {
		super(msg, e);
		this.errcode = errcode;
		this.msg = msg;
	}

	public TranslateException(Throwable e) {
		super(e);
	}

	public TranslateException(int errcode) {
		this.errcode = errcode;
	}

	public TranslateException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public TranslateException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public int getErrcode() {
		return this.errcode;
	}

	public String getMsg() {
		return this.msg;
	}
}
