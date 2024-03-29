package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OuvreBDD {
	
	    private String DBPath = "Chemin aux base de donn�e SQLite";
	    private Connection connection = null;
	    private Statement statement = null;
	 
	    public OuvreBDD(String dBPath) {
	        DBPath = dBPath;
	    }
	 
	    public void connect() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
	            statement = connection.createStatement();
	            System.out.println("Connexion a " + DBPath + " avec succ�s");
	        } catch (ClassNotFoundException notFoundException) {
	            notFoundException.printStackTrace();
	            System.out.println("Erreur de connecxion");
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            System.out.println("Erreur de connecxion");
	        }
	    }
	 
	    public void close() {
	        try {
	            connection.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
//	    public ResultSet query(String request) {
//	        ResultSet resultat = null;
//	        try {
//	            resultat = statement.executeQuery(request);
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            System.out.println("Erreur dans la request : " + request);
//	        }
//	        return resultat;
//	  
//	    } 
	}
