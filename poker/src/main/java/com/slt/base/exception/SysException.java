package com.slt.base.exception;

import java.util.Date;

/**
 * 定义系统级异常
 * 
 * @author maoyl05
 *
 */
public class SysException extends RuntimeException {

	private static final long serialVersionUID = 4111628035487842021L;
	private Date date;
	private String message;

	public SysException(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SysException [date=" + date + ", message=" + message + "]";
	}
}
