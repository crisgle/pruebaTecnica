package com.hiberus.prueba.model;

public class ResponseError {

	private String CodigoErrorHttp;
	private String Message;
	
	
	public ResponseError() {
		super();
	}
	
	public String getCodigoErrorHttp() {
		return CodigoErrorHttp;
	}
	public void setCodigoErrorHttp(String codigoErrorHttp) {
		CodigoErrorHttp = codigoErrorHttp;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
}
