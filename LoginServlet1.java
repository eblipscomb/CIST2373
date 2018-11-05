/*
 * Ellen Lipscomb
 * CIST 2373 Java III
 * Lab #5 - Login Servlet
 * Due: 10/10/17
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.sql.*;

// Login servlet 

@WebServlet(urlPatterns = {"/LoginServlet"})
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
    
    // declare customer object
    Customer c1;    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id, pw;
        
        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pwtb");                      
        
            if (checkPw(id,pw)) { // A valid ID & PW is in db        
            
                // Lab 5 Part IV
                // Put Customer object in the session
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("c1", c1);
                System.out.println("Customer added to Session/scheduling AccountLookup.jsp");
                    

                // Lab 5 Part III
                // Use RequestDispatcher to forward to AccountLookup.jsp (Successful login)
                RequestDispatcher rd = request.getRequestDispatcher("/accountLookup.jsp");   
                rd.forward(request, response);
        
            } //end if
            else { // invalid ID and/or PW        
        
                // Lab 5 Part II
                // Use RequestDispatcher to forward to failedLogin.jsp (login failed)
                RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
                rd.forward(request, response);
        
            } //end else
            }//end try
        
            catch (Exception err) {
                System.out.println("Error: " + err);
            } //end catch
    }
    
    // Check for valid login password
    public boolean checkPw(String loginId, String loginPw) {
        boolean valid = false;
        String id = loginId;
        String pw = loginPw;
        
                
        
        // Lab 5 Part I Use Customer object to check for matching pw in database
        c1 = new Customer();
        c1.selectDB(id);
        String pwdb = c1.getCustPassword();
        if (pw.equals(pwdb)) {        
            valid = true;
        } //end if            
                     
        return valid;
    } //end checkPw() 

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
