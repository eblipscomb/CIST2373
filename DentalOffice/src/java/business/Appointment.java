/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - Dental Appointment
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines an appointment business object.
*/

package business;

import java.sql.*;

public class Appointment {
    private String apptDateTime;
    private String patId;
    private String dentId;
    private String procCode;    
    
    private boolean hasAppt = false;

    /** Construct an appointment object with no-args (setter methods will be used to set field values */
    public Appointment() {

    }
    
    /** Construct an appointment object with specified values */
    public Appointment(String dateTime, String pat, String dent, String code) {
        apptDateTime = dateTime;
        patId = pat;
        dentId = dent;
        procCode = code;
    }
    
    /** Get and Set methods for appointment object properties */
    // Return the date/time of this appointment
    public String getApptDateTime(){ return apptDateTime; }
        
    // Set the date/time of this appointment
    public void setApptDateTime(String dateTime) { apptDateTime = dateTime; }
    
    // Return the patient id of this appointment
    public String getPatId() { return patId; }
    
    // Set the patient id of this appointment
    public void setPatId(String pat) { patId = pat; }
    
    // Return the dentist of this appointment
    public String getDentId() { return dentId; }
        
    // Set the dentist of this appointment
    public void setDentId(String dent) { dentId = dent; }
    
    // Return the procedure code of this appointment
    public String getProcCode() { return procCode; }
    
    // Set the procedure code of this appointment
    public void setProcCode(String code) { procCode = code; }
    
    // Return the "has appointment?" state of this object
    public boolean getHasAppt() { return hasAppt; }
    
    /** Display appointment info for testing */
    public void display() {
        if (hasAppt) {
            System.out.printf("Appointment Date/Timee: %s\nPatient ID: %s\nDentist ID: %s\nProcedure Code: %s\n", 
                apptDateTime, patId, dentId, procCode);
        }        
    }
    
    /** methods for database select, insert and delete */
    
    // Select Appointment from database
    public void selectDB(String pat) {        
        patId = pat;
            
        try {      
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
            // Load Driver            
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Create sql string
            String sql = "Select * from Appointments where patID='"+getPatId()+"'";   
                                
            // Check for properly formed sql
            System.out.println(sql);
            
            // Execute Statement
            ResultSet rs = stmt.executeQuery(sql);           
                        
            if (rs.next()){
                setDentId(rs.getString(2));
                setProcCode(rs.getString(3));
                setApptDateTime(rs.getString(4));
                hasAppt = true;
            }
            else {
                //no appointment                
                // output message for testing
                System.out.println("No Appointments");
            }            
            
            // close connection
            con.close();            
        } //end try
        
        catch (Exception err) {
            System.out.println("Error: " + err);
            
        } //end catch
        
    } //end selectDB()
    
    /** Select Appointment from database...checking for scheduled appointment with a specific dentist*/
    public void selectDB(String dateTime, String d) {        
        apptDateTime = dateTime;
        dentId = d;
            
        try {      
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
            // Load Driver            
            String connURL="jdbc:ucanaccess://c:/Users/Ellen/Documents/CIST2373/DentistOfficeACCDB.accdb";
            
            // Get Connection
            Connection con = DriverManager.getConnection(connURL);
            
            // Create Statement
            Statement stmt = con.createStatement();
            
            // Create sql string
            String sql = "Select * from Appointments where apptDateTime='"+getApptDateTime()+"' and dentID='"+getDentId()+"'";   
                                
            // Check for properly formed sql
            System.out.println(sql);
            
            // Execute Statement
            ResultSet rs = stmt.executeQuery(sql);           
                        
            if (rs.next()){
                //dentist has appointment at selected date/time
                // output message for testing
                System.out.println("dentist has appointment at selected date/time");
                setPatId(rs.getString(1));
                setProcCode(rs.getString(3));                
                hasAppt = true;
            }
            else {
                //dentist does not have an appointment at selected date/time                
                // output message for testing
                System.out.println("dentist does not have an appointment at selected date/time");
            }            
            
            // close connection
            con.close();            
        } //end try
        
        catch (Exception err) {
            System.out.println("Error: " + err);
            
        } //end catch
        
    } //end selectDB()
    
    // insert appointment into database (insertDB() will also be used with deleteDB() to change an appointment)
    public void insertDB(String dateTime, String pat, String dent, String code) {
        apptDateTime = dateTime;
        patId = pat;
        dentId = dent;
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
            String sql = "Insert into Appointments values ('"+getPatId()+"',"+                                                            
                                                            "'"+getDentId()+"',"+
                                                            "'"+getProcCode()+"',"+
                                                            "'"+getApptDateTime()+"')";   
                                
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
    
    // deleteDB() will be used with insertDB() to change an appointment
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
            //String sql = "Delete from Appointments where patID='"+getPatId()+"and dentID='"+getDentId()+"'";   
            String sql = "Delete from Appointments where patID='"+getPatId()+"'";
                                
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
    
    /** Main method (Using to test Appointment class) */
    public static void main(String[] args) {
        //Appointment a1 = new Appointment();
        // testing selectDB()
        //a1.selectDB("A9112");        
        //testing insertDB()
        //a1.insertDB("Dec 4, 2013, 10am","A9111", "D2111", "P780");
        //a1.insertDB("Dec 22, 2017, 11am","A9998", "D2111", "P114");
        //testing deleteDB()
        //a1.selectDB("A9111");
        //a1.deleteDB();
        //a1.display();
        
    }
}
