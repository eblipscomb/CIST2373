package business;

/**
 * Class: CIST 2373 Java III
 * Description: Code for InsufficentFundsException (works with Lab #4 Part I 2
 * Due: 10/3/2017
 * @author Ellen Lipscomb
 * @version 1.0
 **/
 
/* 
This program defines an "InsufficentFundsException" object  
*/

public class InsufficientFundsException extends Exception {
	private double amount;
	private String message = "Error: Insufficient funds. Cannot withdraw $ ";
		
	public InsufficientFundsException(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return (message + String.format("%-10.2f", amount));
	}
	
} // end class   
