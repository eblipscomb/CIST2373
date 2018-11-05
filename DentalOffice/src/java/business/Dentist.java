/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - Dentist 
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines a dentist business object.
*/

package business;

import java.sql.*;

public class Dentist {
    private String dentId;
    private String dentPassword;
    private String dentFirstName;
    private String dentLastName;    
    private String dentEmail;
    private String dentOffice;
    public AppointmentList dList = new AppointmentList(); 
			
	/** Construct a dentist object with no-args to initialize field values */
	public Dentist() {
            dentId = "";
            dentPassword = "";
            dentFirstName = "";
            dentLastName = "";            
            dentEmail = "";
            dentOffice = "";
	}
	
	/** Construct a dentist object with specified values */
	public Dentist(String newDentId, String newDentPassword, String newDentFirstName, String newDentLastName, String newDentEmail, String newDentOffice) {
            dentId = newDentId;
            dentPassword = newDentPassword;
            dentFirstName = newDentFirstName;
            dentLastName = newDentLastName;
            dentEmail = newDentEmail;
            dentOffice = newDentOffice;
	}
	
	/** Get and Set methods for dentist object properties */
        // Set ID of this dentist
	public void setDentId(String dentId){ this.dentId = dentId; }
	
	// Return ID of this dentist
	public String getDentId(){ return dentId; }
	
	// Set PW for this dentist
	public void setDentPassword(String dentPassword){ this.dentPassword = dentPassword; }
	
	// Return PW of this dentist
	public String getDentPassword(){ return dentPassword; }
        
        // Set first name of this dentist
	public void setDentFirstName(String dentFirstName){ this.dentFirstName = dentFirstName; }
	
	// Return first name of this dentist
	public String getDentFirstName(){ return dentFirstName; }
	
        // Set last name of this dentist
	public void setDentLastName(String dentLastName){ this.dentLastName = dentLastName; }
	
	// Return last name of this dentist
	public String getDentLastName(){ return dentLastName; }
                
        // Set email for this dentist
	public void setDentEmail(String dentEmail){ this.dentEmail = dentEmail; }
	
	// Return email of this dentist
	public String getDentEmail(){ return dentEmail; }
        
        // Set office for this dentist
	public void setDentOffice(String dentOffice){ this.dentOffice = dentOffice; }
	
	// Return office of this dentist
	public String getDentOffice(){ return dentOffice; }
        
	/** Display dentist info for testing */
	public void display() {
		System.out.printf("Dentist Id: %s\nPassword: %s\nFirstName: %s\nLastName: %s\nEmail: %s\nOffice: %s\n", 
			dentId, dentPassword, dentFirstName, dentLastName, dentEmail, dentOffice);
                dList.displayAppointments(); 
	} // end of Display method                
        
        /** methods for database access: select, insert and delete dentist and display dentist's appointments  */
        // Select dentist from database
        public void selectDB(String id) {
            dentId = id;                       
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Select * from Dentists where id='"+getDentId()+"'";
                               
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);
                           
                // Set the dentist properties
                rs.next();
                setDentPassword(rs.getString(5));
                setDentFirstName(rs.getString(2));
                setDentLastName(rs.getString(3));
                setDentEmail(rs.getString(4));
                setDentOffice(rs.getString(6));
                /*System.out.println("string 1: "+rs.getString(1));
                System.out.println("string 2: "+rs.getString(2));
                System.out.println("string 3: "+rs.getString(3));
                System.out.println("string 4: "+rs.getString(4));
                System.out.println("string 5: "+rs.getString(5));
                System.out.println("string 6: "+rs.getString(6)); */
                
                // display dentist's appointments
                displayAppointments();
                
                //close connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
    } //end selectDB()      
        
    // insert dentist into database (insertDB() will be used with deleteDB() to change dentist info)
    public void insertDB(String id, String pw, String fn, String ln, String email, String office) {
            dentId = id;
            dentPassword = pw;
            dentFirstName = fn;
            dentLastName = ln;
            dentEmail = email;
            dentOffice = office;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
            // Load Driver
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Create sql string
            String sql = "Insert into Dentists values ('"+getDentId()+"',"+                                                             
                                                        "'"+getDentFirstName()+"',"+
                                                        "'"+getDentLastName()+"',"+
                                                        "'"+getDentEmail()+"',"+
                                                        "'"+getDentPassword()+"',"+
                                                        "'"+getDentOffice()+"')";   
                                
            // Check for properly formed sql
            System.out.println(sql);
                                                   
            // Execute Statement
            int n = stmt.executeUpdate(sql);
            
            // testing for successful insert
            if (n==1)
                System.out.println("insert successful"); 
            else
                System.out.println("insert failed");
            
            // close connection
            con.close();
        } //end try
        catch (Exception err) {
            System.out.println("Error: " + err);
        } //end catch
    }//end insertDB()
    
    // deleteDB() will be used with insertDB() to change a dentist's info
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
            // Load Driver
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Create sql string
            String sql = "Delete from Dentists where id='"+getDentId()+"'";   
                                
            // Check for properly formed sql
            System.out.println(sql);
                                                   
            // Execute Statement
            int n = stmt.executeUpdate(sql);
            
            // testing for successful insert
            if (n==1)
                System.out.println("delete successful"); 
            else
                System.out.println("delete failed");
            
            // close connection
            con.close();
        } //end try
        catch (Exception err) {
            System.out.println("Error: " + err);
        } //end catch
    }//end deleteDB()    
    
    //display appointments
    public void displayAppointments() {
        //dentId = id;
        
        try {                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Select * from Appointments where dentId='"+getDentId()+"'";
                               
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);        
                                
                // Add appointments to list
                while (rs.next()) {
                    dList.addAppointment(new Appointment(rs.getString(4),rs.getString(1),rs.getString(2),rs.getString(3)));                    
                }      
                
                //close connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
    } //end displayAppointments
    
    // Main method (Using to test Dentist class)
    public static void main(String[] args) {
        Dentist d1 = new Dentist();
        //testing selectDB()
        //d1.selectDB("D201");
        //testing insertDB()
        //d1.insertDB("D2111", "211", "Mark", "Jones", "mjones@yahoo.com", "552");
        d1.insertDB("D2112", "222", "Christine", "Jones", "cjones@yahoo.com", "552");
        //testing deleteDB()
        //d1.selectDB("D2111");
        //d1.deleteDB();
        d1.display();
        
    } //end main
} //end Dentist class
