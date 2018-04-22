package de.asheesh.element;
/**
 * Transaction Event Class. Storing amount.
 * 
 * @author Asheesh
 *
 */
public class TransactionEvent {
	private double amount;
	
	public TransactionEvent(double amt){
		amount=amt;
	}
	
	public double getAmount(){
		return amount;
	}
	
}
