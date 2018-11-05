/**
 * Class: CIST 2373 Java III
 * Description: Solution to Lab #4 Part II 
 * Due: 10/03/2017
 * @author Ellen Lipscomb
 * @version 1.0
 **/

/* 
This program defines an account list business object.
*/

package business;

//import Account;
import java.sql.*;

public class AccountList {
    
    public Account[] aList = new Account[10]; // Up to 10 accounts can make up a list 
    private int count = 0;
    
    // Constuct an accountList object (I think this is there by default)
    public AccountList() {
	
    }
    
    public int getCount(){
        return count;
    }
    
    // Add Account to the Account Method
    public void addAccount(Account a1) {
        aList[count] = a1;
        count++;
    }
    
    public void displayAccount() {
        System.out.println("Number of accounts: " + count);
        System.out.println("______________________________________________");
        for (int i = 0; i < count; i++) {
            aList[i].display();
            System.out.println("______________________________________________");
        }
    } 
            
    // Main method (Using to test AccountList class)
    public static void main(String[] args) {
       /* AccountList a = new AccountList();
        a.addAccount(new Account("90088", "3004", "MMA", 200.00));
        a.addAccount(new Account("80088", "3004", "SAV", 200.00));        
        a.displayAccount(); */    
    }
}
