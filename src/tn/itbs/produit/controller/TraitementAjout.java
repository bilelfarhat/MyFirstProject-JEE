package tn.itbs.produit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TraitementAjout")
public class TraitementAjout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection cnx;

    public void init() throws ServletException {
        cnx=DBConnection.getConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String quantite = request.getParameter("quantite");

        try {
            String query = "INSERT INTO Produit (id, nom, qte) VALUES (?, ?, ?)";
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, nom);
            pst.setString(3, quantite);
            pst.executeUpdate();
            pst.close();
            cnx.close();

            // Redirect to a confirmation page after successful insertion
            response.sendRedirect("./Menu.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error processing SQL query", e);
        }
    }

    public void destroy() {

                DBConnection.closeConnection();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String id = request.getParameter("id");
        String quantiteParam = request.getParameter("quantite");

        // Check if quantiteParam is null or empty
        if (quantiteParam == null || quantiteParam.isEmpty()) {
            // Handle the case where quantiteParam is null or empty
            // For example, you can output an error message or redirect the user to another page
            response.getWriter().println("Quantite parameter is missing or empty.");
            return;
        }

        // Convert quantiteParam to an integer
        int quantite = 0;
        try {
            quantite = Integer.parseInt(quantiteParam);
        } catch (NumberFormatException e) {
            // Handle the case where quantiteParam cannot be parsed as an integer
            // For example, you can output an error message or redirect the user to another page
            response.getWriter().println("Invalid value for quantite parameter.");
            return;
        }

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Perform the search query based on the provided ID
            String query = "SELECT * FROM Produit WHERE id = ?"; // Obtain database connection
            pst = cnx.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();

            // Process the search results
            if (rs.next()) {
                // Product found, retrieve current quantity
                int qte = rs.getInt("qte");
                
                // Check if the available quantity is sufficient
                if (quantite <= qte) {
                    // Update the quantity in the database
                    String updateQuery = "UPDATE Produit SET qte = qte - ? WHERE id = ?";
                    PreparedStatement updatePst = cnx.prepareStatement(updateQuery);
                    updatePst.setInt(1, quantite);
                    updatePst.setString(2, id);
                    updatePst.executeUpdate();
                    updatePst.close();
                    
                    // Output success message
                    response.getWriter().println("Achat confirmed successfully.");
                } else {
                    // Insufficient stock, output message
                    response.getWriter().println("Rupture de stock.");
                }
            } else {
                // Product not found
                response.getWriter().println("Product not found.");
            }
        } catch (SQLException e) {
            throw new ServletException("Error processing SQL query", e);
        } finally {
            // Close resources in finally block to ensure they are always closed
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception
            }
        }
    }

}
