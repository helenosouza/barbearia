package com.projeto.barbearia.resources.exceptions;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}



	public List<FieldMessage> getErros() {
		return erros;
	}



	public void addErrors(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
}
