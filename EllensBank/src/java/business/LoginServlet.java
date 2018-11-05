/*
 * Ellen Lipscomb
 * CIST 2373 Java III
 * Lab #5 - Login Servlet + Lab #7 Part A
 * Due: 10/24/17
 */

package business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

// Login servlet 
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id, pw, custPW;               
        
        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pwtb");                      
                    
            Customer c1 = new Customer();                         
            c1.selectDB(id);  
            
            // Put Customer object in the session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1", c1);   
                               
            // Get password from customer object
            custPW = c1.getCustPassword();
            
            if (pw.equals(custPW)) {        
                // Login Successful 
                System.out.println("Customer added to Session/Login Successful/scheduling DisplayAccounts.jsp");    
                // Lab #7 Part A
                // Use RequestDispatcher to forward to DisplayAccounts.jsp
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccounts.jsp");   
                rd.forward(request, response); 
            } //end if  
            else {
                // Login Failed!
                System.out.println("Customer added to Session/Failed Login/scheduling LoginError.jsp");
                // Use RequestDispatcher to forward to LoginError.jsp 
                RequestDispatcher rd = request.getRequestDispatcher("/LoginError.jsp");
                rd.forward(request, response);
            } //end else         
                            
        }//end try//end try
        
        catch (Exception err) {
            System.out.println("Error: " + err);
        } //end catch
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
