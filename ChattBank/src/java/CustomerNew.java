/**
 * Class: CIST 2373 Java III
 * Description: Solution to Lab #3 Part I & Lab #4 Part III
 * Due: 10/3/2017
 * @author Ellen Lipscomb
 * @version 1.0
 **/



/* 
This program defines a customer business object.
*/

import business.AccountList;
import business.Account;
import java.sql.*;

public class CustomerNew{
	private String custID;
	private String custPassword;
        private String custFirstName;
        private String custLastName;
        private String custAddress;
        private String custEmail;
        public AccountList aList = new AccountList(); // Lab #4 Part III
			
	// Constuct a customer object with no-args to initialize field values
	public CustomerNew() {
            custID = "";
            custPassword = "";
            custFirstName = "";
            custLastName = "";
            custAddress = "";
            custEmail = "";
	}
	
	// Construct a Customer object with specified values
	public CustomerNew(String newCustID, String newCustPassword, String newCustFirstName, String newCustLastName, String newCustAddress, String newCustEmail) {
            custID = newCustID;
            custPassword = newCustPassword;
            custFirstName = newCustFirstName;
            custLastName = newCustLastName;
            custAddress = newCustAddress;
            custEmail = newCustEmail;
	}
	
	// Set customer ID for this customer
	public void setCustID(String custID){ this.custID = custID; }
	
	// Return customer ID of this customer
	public String getCustID(){ return custID; }
	
	// Set customer PW for this customer
	public void setCustPassword(String custPassword){ this.custPassword = custPassword; }
	
	// Return customer PW of this customer
	public String getCustPassword(){ return custPassword; }
        
        // Set first name for this customer
	public void setCustFirstName(String custFirstName){ this.custFirstName = custFirstName; }
	
	// Return first name of this customer
	public String getCustFirstName(){ return custFirstName; }
	
        // Set last name for this customer
	public void setCustLastName(String custLastName){ this.custLastName = custLastName; }
	
	// Return last name of this customer
	public String getCustLastName(){ return custLastName; }
        
        // Set address for this customer
	public void setCustAddress(String custAddress){ this.custAddress = custAddress; }
	
	// Return address of this customer
	public String getCustAddress(){ return custAddress; }
        
        // Set email for this customer
	public void setCustEmail(String custEmail){ this.custEmail = custEmail; }
	
	// Return email of this customer
	public String getCustEmail(){ return custEmail; }
        
	// Display customer info for testing
	public void display() {
		System.out.printf("CustID: %s\nPW: %s\nFN: %s\nLN: %S\nAddress: %s\nEmail: %s\n", 
			custID, custPassword, custFirstName, custLastName, custAddress, custEmail);
                aList.displayAccount(); // Lab #4 Part III
	} // end of Display method   
        
        // Select customer from database
        public void selectDB(String newCustID) {
            custID = newCustID;
                        
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string to look up the customer in the Customer table 
                String sql = "Select * from Customers where custID='"+custID+"'";
                                
                // Check for properly formed sql
                //System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);
                           
                // Set the customer properties
                rs.next();
                setCustPassword(rs.getString(2));
                setCustFirstName(rs.getString(3));
                setCustLastName(rs.getString(4));
                setCustAddress(rs.getString(5));
                setCustEmail(rs.getString(6)); 
            
                // Create sql string to return all accounts for this customer in Accounts table
                String sql2 = "Select * from Accounts where Cid ='"+custID+"'";
                
                // Check for properly formed sql
                //System.out.println(sql2);
            
                // Execute Statement
                ResultSet rs2 = stmt.executeQuery(sql2);
                
                // Add accounts to list - Lab #4 Part III
                while (rs2.next()) {
                    aList.addAccount(new Account(rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getDouble(4)));
                }                              
                
                // Close Connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
        } //end selectDB()
	
        // Insert a  customer into database
        public void insertDB(String newCustID, String newCustPassword, String newCustFirstName, String newCustLastName, String newCustAddress, String newCustEmail) {
            custID = newCustID;
            custPassword = newCustPassword;
            custFirstName = newCustFirstName;
            custLastName = newCustLastName;
            custAddress = newCustAddress;
            custEmail = newCustEmail;
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Insert into Customers values('"+getCustID()+"',"+
                                                            "'"+getCustPassword()+"',"+
                                                            "'"+getCustFirstName()+"',"+
                                                            "'"+getCustLastName()+"',"+
                                                            "'"+getCustAddress()+"',"+
                                                            "'"+getCustEmail()+"')"; 
                                                            
                //String sql = "Insert into Customers values (custID, custPassword, custFirstName, custLastName, custAddress, custEmail)";
                        
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                int n = stmt.executeUpdate(sql);
                if (n == 1)
                    System.out.println("Insert was successful!");
                else
                    System.out.println("Insert failed!");               
                              
                // Close Connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
        } //end insertDB()
        
        // Insert a customer into database
        public void deleteDB() {
                       
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");    

                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/ChattBankMDB.mdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                //String sql = "Delete from Customers where CustID='"+getAcctNo()+"'";
                String sql = "Delete from Customers where CustID=" + getCustID();
                
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                int n = stmt.executeUpdate(sql);
                if (n == 1)
                    System.out.println("Delete was successful!");
                else
                    System.out.println("Delete failed!");               
                              
                // Close Connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
        } //end deleteDB()
        
	// Main method (Using to test Account class)
	public static void main(String[] args) {
	
        // Code to test Customer class
                          
                // testing selecting a customer from the database
                CustomerNew c1 = new CustomerNew();
                c1.selectDB("3003");
		c1.display();   
                
              /*  // testing inserting a customer into the database 
                Customer c2 = new Customer();
                c2.insertDB("3007", "7777", "Bruce", "Wayne", "Stately Wayne Manor", "thedarkknight@dcc.com");
                c2.display(); */
                
              /*  // testing deleting a customer from the database
                Customer c3 = new Customer();
                c3.selectDB("3007");
                c3.deleteDB();
                c3.display();  */
        
	} // end of Main
	
}// end of class
