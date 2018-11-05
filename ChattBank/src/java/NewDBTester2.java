/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ellen
 */

import java.sql.*;

public class NewDBTester2 {
    public static void main(String[] args) {
        String id = "3001";     
        String pw = "1234";
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            // Load Driver
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2372/ChattBankACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Execute Statement
            ResultSet rs;
            //rs = stmt.executeQuery("Select * from Customers");
            String sql = "Select CustPassword from Customers where CustID='"+id+"'";
            rs = stmt.executeQuery(sql);
            
            System.out.println("The SQL: " + sql);
            
            // Process Data
            System.out.println("Here is the output:");
            /*System.out.println("CustomerID  Password  FirstName  LastName    Address     Email");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "        " + rs.getString(2) + "      " + rs.getString(3) + "       " + rs.getString(4) + 
                        "       " + rs.getString(5) + "  " + rs.getString(6));
            } //end while */
            
            rs.next();
            
            if (pw.equals(rs.getString(1))) {
                System.out.println("Success! Password " + rs.getString(1) + " is a match!");
                //valid = true;
            } //end if
            //System.out.println("string 1: " + rs.getString(1));
            
            
            // Close Connection
            con.close();
        } //end try
        
        catch (Exception err) {
            System.out.println("Error: " + err);
        } //end catch 
    } //end main
}
