/*
 * Ellen Lipscomb
 * CIST 2373 Java III
 * Lab #6 - AccountLookup Servlet - Part IV
 * Due: 10/10/17
 */

package business;

import business.Account;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@WebServlet(name = "AccountLookupServlet", urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acctNo = "";             
        
        try {
            acctNo = request.getParameter("acctnotb");
        
            Account a1 = new Account();
            a1.selectDB(acctNo);
            a1.display();
        
            // Put Account object in the session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("a1", a1);
            System.out.println("Account added to Session/scheduling DisplayAccount.jsp");       
        
            // Use RequestDispatcher to forward to DisplayAccount.jsp 
            RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");   
            rd.forward(request, response); 
        
        }//end try
        
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
