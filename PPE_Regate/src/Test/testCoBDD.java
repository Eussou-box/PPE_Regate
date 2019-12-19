package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testCoBDD {
	private static final String PILOTE = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/testRegates";
	private static final String TIMEZONE = "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String MDP = "";
	private static Statement st = null;
	private static Connection cnx = null;
	private static ResultSet rs = null;
	
	public void connect() {
        try {
            Class.forName(PILOTE);
            cnx = DriverManager.getConnection(URL + TIMEZONE, LOGIN, MDP);
            st = cnx.createStatement();
            System.out.println("Connexion a " + URL + " avec succès");
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
            cnx.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static Statement getSt() {
		return st;
	}

	public static void setSt(Statement st) {
		testCoBDD.st = st;
	}

	public static Connection getCnx() {
		return cnx;
	}

	public static void setCnx(Connection cnx) {
		testCoBDD.cnx = cnx;
	}
    
    
}
