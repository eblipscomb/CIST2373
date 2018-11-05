/**
 * Class: CIST 2373 Java III
 * Description: Solution to Lab #3 Part II & Lab #4 Part I
 * Due: 10/3/2017
 * @author Ellen Lipscomb
 * @version 1.0
 **/

/* 
This program defines an account business object.
*/

package business;

import java.sql.*;

public class Account{
	private String acctNo;
	private String cid;
        private String type;
	private double balance;
		
	// Constuct an account object with no-args (setter methods will be used to set field values
	public Account() {
	}
	
	// Construct an account object with specified values
	public Account(String newAcctNo, String newCID, String newType, double newBalance) {
		acctNo = newAcctNo + ""; 
		cid = newCID;
                type = newType;
		balance = newBalance;
	}
	
	// Set account number for this account
	public void setAcctNo(String acctNo){
		this.acctNo = acctNo;
	}
	
	// Return the account number of this account
	public String getAcctNo(){
		return acctNo;
	}
	
	// Set customer id for this account
	public void setCID(String cid){
		this.cid = cid;
	}
  
	// Return the customer id of this account
	public String getCID(){
		return cid;
	}
        
        // Set type for this account
        public void setType(String type){
		this.type = type;
	}
  
	// Return the type of this account
	public String getType(){
		return type;
	}
        	
	// Set the balance for this account
	public void setBalance(double balance){
		this.balance = balance;
	}
  
	// Return the balance of this account
	public double getBalance(){
		return balance;
	}           
		
	// Display account info
	public void display() {
		System.out.printf("Account Number: %s\nCID: %s\nType: %s\nBalance: $%-10.2f\n", 
			acctNo, cid, type, balance);
	} // end of Display method 
        
        // Select account from database
        public void selectDB(String newAcctNo) {
            acctNo = newAcctNo;
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Select * from Accounts where AcctNo='"+getAcctNo()+"'";
                
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);
                           
                // Set the Account properties
                rs.next();
                setCID(rs.getString(2));
                setType(rs.getString(3));
                setBalance(rs.getDouble(4));
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
        } //end selectDB()
	
        // Deposit to this account
        public void deposit(double amount) {
            balance += amount;
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
                
                // Create sql string                              
                String sql = "Update Accounts set Balance = "+getBalance()+ 
                        " where AcctNo='"+getAcctNo()+"'";
                
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                int n = stmt.executeUpdate(sql);
                if (n == 1)
                    System.out.println("Update was successful!");
                else
                    System.out.println("Update failed!");               
                              
                // Close Connection
                con.close();                                                           
            } //end try
            
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        } // end deposit
        
        // Withdraw from this account
        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= balance) {
                balance -= amount;
                
                try {
                
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                    // Load Driver
                    String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                    // Get Connection
                    Connection con = DriverManager.getConnection(connURL);
            
                    // Create Statement
                    Statement stmt = con.createStatement();
                
                    // Create sql string                              
                    String sql = "Update Accounts set Balance = "+getBalance()+ 
                        " where AcctNo= '"+getAcctNo()+"'";
                
                    // Check for properly formed sql
                    System.out.println(sql);
            
                    // Execute Statement
                    int n = stmt.executeUpdate(sql);
                    if (n == 1)
                        System.out.println("Update was successful!");
                    else
                        System.out.println("Update failed!");               
                              
                    // Close Connection
                    con.close();                                                           
                } //end try
            
                catch (Exception err) {
                    System.out.println("Error: " + err);
                } //end catch
            } //end if
            else {
                throw new InsufficientFundsException(amount);
            } //end else
        } // end withdraw        
        
	// Main method (Using to test Account class)
	public static void main(String[] args) {
	
        // Code to test Account class     
                
                // testing selecting an account from the database - Lab #3 Part II
                /*Account a1 = new Account();
                a1.selectDB("90002");
		double abalance = a1.getBalance();
                System.out.println("Balance: " + abalance); */
                
                // testing deposit and withraw methods Lab #4 Part I
                //Account a1 = new Account();
                //a1.selectDB("90002");
                //a1.display();
                //a1.deposit(300.00);
                /*try {
                    a1.withdraw(3000.00);
                }
                catch (InsufficientFundsException ex) {
                    System.out.println(ex);
                } */
                
                //a1.display();                  
        
	} // end of Main
	
}// end of class