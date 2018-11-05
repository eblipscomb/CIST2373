/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - LoginServlet 
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines a login servlet for the patient and dentist login pages.
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        String id, pw, user;               
        
        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pwtb");     
            user = request.getParameter("logintype");
            
            if (user.equals("pat")) {
                Patient p1 = new Patient();
                p1.selectDB(id);
                
                Appointment a1 = new Appointment();
                a1.selectDB(id);
                
                // Put patient object and appointment object in the session
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("p1", p1); 
                ses1.setAttribute("a1", a1);                   
                
                if (pw.equals(p1.getPatPassword()) && id.equals(p1.getPatId())) {        
                    // Login Successful 
                    System.out.println("Patient added to Session/Login Successful/scheduling PatientMenu.jsp");    
                
                    // Use RequestDispatcher to forward to PatientMenu.jsp
                    RequestDispatcher rd = request.getRequestDispatcher("/PatientMenu.jsp");   
                    rd.forward(request, response); 
                } //end if  
                else {
                    // Login Failed!
                    System.out.println("Patient added to Session/Failed Login/scheduling LoginErrorPat.jsp");
                    // Use RequestDispatcher to forward to LoginError.jsp 
                    RequestDispatcher rd = request.getRequestDispatcher("/LoginErrorPat.jsp");
                    rd.forward(request, response);
                } //end else                
            } //end if
            
            if (user.equals("dent")) {
                Dentist d1 = new Dentist();
                d1.selectDB(id);
                
                // Put dentist object in the session
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("d1", d1);                 
                                
                if (pw.equals(d1.getDentPassword()) && id.equals(d1.getDentId())) {        
                    // Login Successful 
                    System.out.println("Dentist added to Session/Login Successful/scheduling DentistMenu.jsp");    
                
                    // Use RequestDispatcher to forward to DentistMenu.jsp
                    RequestDispatcher rd = request.getRequestDispatcher("/DentistMenu.jsp");   
                    rd.forward(request, response); 
                } //end if  
                else {
                    // Login Failed!
                    System.out.println("Dentist added to Session/Failed Login/scheduling LoginErrorDent.jsp");
                    // Use RequestDispatcher to forward to LoginError.jsp 
                    RequestDispatcher rd = request.getRequestDispatcher("/LoginErrorDent.jsp");
                    rd.forward(request, response);
                } //end else           
            } //end if                                   
        }//end try
        
        catch (Exception err) {
            System.out.println("Error: " + err);
        } //end catch
    } //end processRequest

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
