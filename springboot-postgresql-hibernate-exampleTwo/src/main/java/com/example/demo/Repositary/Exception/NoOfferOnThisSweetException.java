package com.example.demo.Repositary.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoOfferOnThisSweetException extends Throwable
{
	private static final long serialVersionUID=1L;
	public NoOfferOnThisSweetException(String msg)
	{
		super(msg);
	}
	

}

/*
@ResponseStatus(value=HttpStatus.NOT_FOUND)  //this will be the exception thrown 
public class ResourceNotFoundException extends Exception  //mentioning exception is mandatory
{
	private static final long serialVersionUID = 1L;  //exception like 404 not found
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
	*/
