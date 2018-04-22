package de.asheesh.exceptions;

public class TransactionException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionException(String msg){
		super(msg);
	}
	
	public TransactionException(Exception e){
		super(e);
	}
	
	public TransactionException(String msg,Exception e){
		super(msg,e);
	}
}
