/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - LoginServlet 
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines an appointment servlet for the patient CreateAppointment page.
*/

package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dateTime, dent, proc;
        
        try {
            
            /**get values from form text boxes */
            dateTime = request.getParameter("datetimetb");
            dent = request.getParameter("dentisttb");
            proc = request.getParameter("proceduretb");            
                                   
            /**create patient & session objects and get patient & 
             objects from session */
            Patient p1;            
            HttpSession ses1;
            ses1 = request.getSession();
            p1 = (Patient)ses1.getAttribute("p1"); 
                        
            /**create appointment object & select patient's appointment from db*/
            Appointment a1 = new Appointment();            
            a1.selectDB(p1.getPatId());
            
            /**if patient has an existing appointment, it's deleted before inserting updated appointment */
            //delete existing appointment & insert new appointment
            a1.deleteDB();   
            
            /**before new appointment scheduled check if dentist already has an appointment for date/time specified */
            Appointment a2 = new Appointment();
            a2.selectDB(dateTime, dent);
            if (a2.getHasAppt()) {
                System.out.println("Selected dentist has a schedule conflict. Pick another date/time or dentist");
                /** Use RequestDispatcher to forward to CreateAppointment.jsp to re-display updated appointment info */
                RequestDispatcher rd = request.getRequestDispatcher("/CreateAppointment2.jsp");   
                rd.forward(request, response);
            }
            else {
                //schedule the appointment
                a1.insertDB(dateTime, p1.getPatId(), dent, proc);    
                a1.selectDB(p1.getPatId());                      
            
                /**remove "old" appointment object from session */
                ses1.removeAttribute("a1");
                       
                // Put new appointment object in the session
                ses1.setAttribute("a1", a1);
                /*System.out.println("testing:");
                System.out.println("date/time: "+a1.getApptDateTime());
                System.out.println("procedure: "+a1.getProcCode());
                System.out.println("Has Appt: "+a1.getHasAppt()); */            
            
                /** Use RequestDispatcher to forward to PatientMenu.jsp to display updated appointment info */
                RequestDispatcher rd = request.getRequestDispatcher("/PatientMenu.jsp");   
                rd.forward(request, response);
            }    
        }
        catch (Exception err){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
