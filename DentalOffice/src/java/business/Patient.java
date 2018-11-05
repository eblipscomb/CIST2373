/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - Patient 
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines a patient business object.
*/

package business;

import java.sql.*;

public class Patient {
    private String patId;
    private String patPassword;
    private String patFirstName;
    private String patLastName; 
    private String patAddress;
    private String patEmail;
    private String patInsCo;
    public Appointment patAppt = new Appointment();
    
    // Constuct a patient object with no-args to initialize field values
	public Patient() {
            patId = "";
            patPassword = "";
            patFirstName = "";
            patLastName = "";
            patAddress = "";
            patEmail = "";
            patInsCo = "";
	}
	
	// Construct a patient object with specified values
	public Patient(String id, String pw, String fn, String ln, String a, String e, String i) {
            patId = id;
            patPassword = pw;
            patFirstName = fn;
            patLastName = ln;
            patAddress = a;
            patEmail = e;
            patInsCo = i;
            
	}
	
	/** Get and Set methods for patient object properties */
        // Set ID of this patient
	public void setPatId(String id){ patId = id; }
	
	// Return ID of this patient
	public String getPatId(){ return patId; }
	
	// Set PW for this patient
	public void setPatPassword(String pw){ patPassword = pw; }
	
	// Return PW of this patient
	public String getPatPassword(){ return patPassword; }
        
        // Set first name of this patient
	public void setPatFirstName(String fn){ patFirstName = fn; }
	
	// Return first name of this patient
	public String getPatFirstName(){ return patFirstName; }
	
        // Set last name of this patient
	public void setPatLastName(String ln){ patLastName = ln; }
	
	// Return last name of this patient
	public String getPatLastName(){ return patLastName; }
                
        // Set address for this patient
	public void setPatAddress(String a){ patAddress = a; }
	
	// Return address of this patient
	public String getPatAddress(){ return patAddress; }

        // Set email for this patient
	public void setPatEmail(String e){ patEmail = e; }
	
	// Return email of this patient
	public String getPatEmail(){ return patEmail; }
        
        // Set insurance co for this patient
	public void setPatInsCo(String i){ patInsCo = i; }
	
	// Return insurance co of this patient
	public String getPatInsCo(){ return patInsCo; }
        
	// Display patient info for testing
	public void display() {
		System.out.printf("Patient Id: %s\nPassword: %s\nFirstName: %s\nLastName: %s\nAddress: %s\nEmail: %s\nInsurance Co: %s\n", 
			patId, patPassword, patFirstName, patLastName, patAddress, patEmail, patInsCo); 
                patAppt.display();
	} // end of Display method            
    
    
        // Select patient from database
        public void selectDB(String id) {
            patId = id;                       
            
            try {
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // Load Driver
                String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
                // Get Connection
                Connection con = DriverManager.getConnection(connURL);
            
                // Create Statement
                Statement stmt = con.createStatement();
            
                // Create sql string
                String sql = "Select * from Patients where patId='"+getPatId()+"'";
                               
                // Check for properly formed sql
                System.out.println(sql);
            
                // Execute Statement
                ResultSet rs = stmt.executeQuery(sql);
                           
                // Set the patient properties
                rs.next();
                setPatPassword(rs.getString(7));
                setPatFirstName(rs.getString(2));
                setPatLastName(rs.getString(3));
                setPatAddress(rs.getString(4));
                setPatEmail(rs.getString(5));
                setPatInsCo(rs.getString(6));
                /*System.out.println("string 1: "+rs.getString(1));
                System.out.println("string 2: "+rs.getString(2));
                System.out.println("string 3: "+rs.getString(3));
                System.out.println("string 4: "+rs.getString(4));
                System.out.println("string 5: "+rs.getString(5));
                System.out.println("string 6: "+rs.getString(6));
                System.out.println("string 7: "+rs.getString(7)); */                     
                
                //close connection
                con.close();
            } //end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
        
    } //end selectDB()
    
    // insert patient into database (insertDB() will be used with deleteDB() to change patient info)
    public void insertDB(String id, String pw, String fn, String ln, String a, String e, String i) {
            patId = id;
            patPassword = pw;
            patFirstName = fn;
            patLastName = ln;
            patAddress = a;
            patEmail = e;
            patInsCo = i;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
            // Load Driver
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Create sql string
            String sql = "Insert into Patients values ('"+getPatId()+"',"+                                                             
                                                        "'"+getPatFirstName()+"',"+
                                                        "'"+getPatLastName()+"',"+
                                                        "'"+getPatAddress()+"',"+    
                                                        "'"+getPatEmail()+"',"+                                                                
                                                        "'"+getPatInsCo()+"',"+
                                                        "'"+getPatPassword()+"')";   
                                
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
    
    // deleteDB() will be used with insertDB() to change a patient's info
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
            String sql = "Delete from Patients where patId='"+getPatId()+"'";   
                                
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
    
    // Main method (Using to test Patient class)
    public static void main(String[] args) {
        Patient p1 = new Patient();
        //testing selectDB()
        //p1.selectDB("A900");
        //testing insertDB()
        //p1.insertDB("A9111", "9999", "Steven", "Smith", "Atlanta", "ssmith@yahoo.com", "Humana");
        p1.insertDB("A9112", "9999", "Susan", "Smith", "Atlanta", "ssmith@yahoo.com", "Humana");
        //p1.insertDB("A9999", "9999", "Joseph", "Miller", "Atlanta", "jm@yahoo.com", "Cigna");
        //p1.insertDB("A9998", "9998", "Carol", "Miller", "Atlanta", "cjm@yahoo.com", "Cigna");
        //testing deleteDB()
        //p1.selectDB("A9998");
        //p1.deleteDB();
        //p1.display();
        
    } //end main
        
} //end Patient class
