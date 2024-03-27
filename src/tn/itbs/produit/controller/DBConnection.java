
package tn.itbs.produit.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mabase?createDatabaseIfNotExist=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Gérer l'erreur de connexion
            }
        }
        return connection;
    }

    // Méthode pour fermer la connexion à la base de données
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Gérer l'erreur de fermeture de connexion
            }
        }
    }
}

