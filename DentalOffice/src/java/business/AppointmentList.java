/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - Appointment List
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines an appointment list business object for a dentist.
*/

package business;

import java.sql.*;
import java.util.ArrayList;

public class AppointmentList {
    
    /** declare variable to reference to ArrayList object */ 
    public ArrayList<Appointment> aList = new ArrayList<>();
   
    /** get the number of appointments in the list */
    public int getCount(){
        return aList.size();
    }
    
    /** add appointment to the list */
    public void addAppointment(Appointment a1) {
        aList.add(a1);
    }
    
    /** diaplay appointments for testing */
    public void displayAppointments() {
        System.out.println("Number of appointments: " + aList.size());
        System.out.println("____________________________________________________________________");
        for (int i = 0; i < aList.size(); i++) {
            aList.get(i).display();
            System.out.println("_____________________________________________________________________");
        }
    } 
            
    /** Main method (Using to test AccountList class) */
    public static void main(String[] args) {
        //AppointmentList a = new AppointmentList();
        //a.addAppointment(new Appointment("Dec 1, 2017, 9am", "A800","D211", "P321"));
        //a.addAppointment(new Appointment("Dec 1, 2017, 11am", "A801","D212", "P114"));        
        //a.displayAppointments();     
    }
    
}
