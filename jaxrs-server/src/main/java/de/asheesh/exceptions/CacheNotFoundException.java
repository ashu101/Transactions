package de.asheesh.exceptions;

public class CacheNotFoundException extends TransactionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CacheNotFoundException(Exception e) {
		super(e);
	}
	
	public CacheNotFoundException(String msg,Exception e){
		super(msg,e);
	}
	public CacheNotFoundException(String msg){
		super(msg);
	}
}
