/**
 * Class: CIST 2373 Java III
 * Description: Dental Office Project - UpdateInfoServlet 
 * Due: 12/5/2017
 * @author Ellen Lipscomb
 * @version 1.0
 */

/** 
This program defines an update information servlet for the patient and dentist personal info pages.
*/
package business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "UpdateInfoServlet", urlPatterns = {"/UpdateInfoServlet"})
public class UpdateInfoServlet extends HttpServlet {

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
        
        String user, fn, ln, a, e, o, i;
        
        try  {
                        
            /**get values from the form */
            user = request.getParameter("logintype");            
            fn = request.getParameter("fntb");
            ln = request.getParameter("lntb");
            e = request.getParameter("emailtb");     
            
            System.out.println("user: "+ user);
            System.out.println("first name: "+ fn);
                        
            /**create a session object */                      
            HttpSession ses1;
            ses1 = request.getSession();
                        
            /**if login is a patient */
            if (user.equals("pat")) {
                //get patient-specific values from form & session
                a = request.getParameter("addresstb");
                i = request.getParameter("inscotb");
                
                System.out.println("address: "+ a);
                System.out.println("insurance: "+ i);
                
                Patient p1 = (Patient)ses1.getAttribute("p1"); 
                p1.deleteDB();
                p1.insertDB(p1.getPatId(), p1.getPatPassword(), fn, ln, a, e, i);
                
                //remove "old" patient object from session
                ses1.removeAttribute("p1");
                       
                // Put "new" (updated) patient object in the session
                ses1.setAttribute("p1", p1);
                
                 // Use RequestDispatcher to forward to PatientMenu.jsp
                RequestDispatcher rd = request.getRequestDispatcher("/PatientMenu.jsp");   
                rd.forward(request, response); 
            }
            else if (user.equals("dent")) {
                //get dentist-specific values from form & session
                o = request.getParameter("officetb");
                Dentist d1 = (Dentist)ses1.getAttribute("d1");
                d1.deleteDB();
                d1.insertDB(d1.getDentId(), d1.getDentPassword(), fn, ln, e, o);
                
                //remove "old" dentist object from session
                ses1.removeAttribute("d1");
                       
                // Put "new" (updated) dentist object in the session
                ses1.setAttribute("d1", d1);
                
                // Use RequestDispatcher to forward to DentistMenu.jsp
                RequestDispatcher rd = request.getRequestDispatcher("/DentistMenu.jsp");   
                rd.forward(request, response);
            }
        }
        catch(Exception err) {
            System.out.println("Error: " + err);
        }
    }//end processRequest

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

