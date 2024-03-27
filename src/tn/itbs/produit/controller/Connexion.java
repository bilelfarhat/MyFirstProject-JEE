package tn.itbs.produit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Connection cnx; 

    /**
     * @see Servlet#init(ServletConfig)
     */

    
    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        cnx = DBConnection.getConnection();
    }

    

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        String login=request.getParameter("login");
        String mdp=request.getParameter("password");
        HttpSession session=request.getSession();
        if (session.getAttribute("login")!=null) {
            response.sendRedirect("./Menu.jsp");
        
        }
        else {
            String req="select * from user where login = ? and password=?";
            try {
                PreparedStatement pst=cnx.prepareStatement(req);
                pst.setString(1,login);
                pst.setString(2, mdp);
                ResultSet rs=pst.executeQuery();
                if(rs.next()) {
                    session.setAttribute("login", login);
                    response.sendRedirect("./Menu.jsp");
                }
                else {
                    response.sendRedirect("./Index.jsp");
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
    }

}
