package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector  {

	 public static Connection connect() throws ClassNotFoundException, SQLException {
	 
		Connection conn = null;
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_EmlakApp", "postgres", "123");
		System.out.println("Baglanti Basarili");
		return conn;
	
}
}
	 
