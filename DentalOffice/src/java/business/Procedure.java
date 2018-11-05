/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - Dental Procedure
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines a procedure business object.
*/

package business;

import java.sql.*;

public class Procedure {
    // fields
    private String procCode;
    private String procName;
    private String procDesc;
    private double procCost;
    
    /** Construct a procedure object with no-args (setter methods will be used to set field values */
    public Procedure() {
    }
    
    /** Construct a procedure object with specified values */
    public Procedure(String code, String name, String desc, double cost){
        procCode = code;
        procName = name;
        procDesc = desc;
        procCost = cost;
    }
    
    /** Get and Set methods for procedure object properties */
    // Return the code of this procedure
    public String getProcCode(){ return procCode; }
        
    // Set the code of this procedure
    public void setProcCode(String code) { procCode = code; }
    
    // Return the name of this procedure
    public String getProcName() { return procName; }
    
    // Set the name of this procedure
    public void setProcName(String name) { procName = name; }
    
    // Return the description of this procedure
    public String getProcDesc() { return procDesc; }
        
    // Set the description of this procedure
    public void setProcDesc(String desc) { procDesc = desc; }
    
    // Return the cost of this procedure
    public double getProcCost() { return procCost; }
    
    // Set the cost of this procedure
    public void setProcCost(double cost) { procCost = cost; }
    
    // Display procedure info for testing 
    public void display() {
	System.out.printf("Procedure Code: %s\nName: %s\nDescription: %s\nCost: $%-10.2f\n", 
            procCode, procName, procDesc, procCost);
    }
    
    /** Select procedure from database */
    public void selectDB(String code) {
            procCode = code;
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Select * from Procedures where procCode='"+getProcCode()+"'";
                               
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);
                           
                // Set the procedure properties
                rs.next();
                setProcName(rs.getString(2));
                setProcDesc(rs.getString(3));
                setProcCost(rs.getDouble(4));
                System.out.println("string 1: "+rs.getString(1));
                System.out.println("string 2: "+rs.getString(2));
                System.out.println("string 3: "+rs.getString(3));
                System.out.println("string 4: "+rs.getString(4));
                
                //close connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
    } //end selectDB()
    
    /** Main method (Using to test Procedure class) */
    public static void main(String[] args) {
        //Procedure p1 = new Procedure();
        // testing selectDB()
        //p1.selectDB("P660");
        //p1.display();
        
    }
}
