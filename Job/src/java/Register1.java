/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ankit
 */
public class Register1 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
        try
     {
           String name = request.getParameter("name");
            String email = request.getParameter("mail");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String education = request.getParameter("education");
            int experience = Integer.parseInt(request.getParameter("experience"));
            String resume = request.getParameter("resume");
            String skills = request.getParameter("skills");
            String desiredJob = request.getParameter("desiredJob");
            boolean termsAgreed = request.getParameter("terms") != null;
            boolean privacyAgreed = request.getParameter("privacy") != null;
     
       //Load the driver class
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection
		
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Job","root","");
		
		//Make the statement object
		
	Statement smt=cn.createStatement();
		
		//execute query
int i = smt.executeUpdate("INSERT INTO user(name, email, phone, address, gender, dob, education, experience, resume, skills, desiredJob, termsAgreed, privacyAgreed) VALUES('" + name + "','" + email + "','" + phone + "','" + address + "','" + gender + "','" + dob + "','" + education + "'," + experience + ",'" + resume + "','" + skills + "','" + desiredJob + "', true, true)");

		
		if(i>0)
                {
                    pw.println("<h3>You have successfully registered</h3>"); 
                    RequestDispatcher rd=request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                   
                    
                }
        
        cn.close();
    }
     catch(Exception e)
     {
         pw.println(e.getMessage());  
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
