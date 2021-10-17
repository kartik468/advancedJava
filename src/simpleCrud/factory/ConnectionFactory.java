package simpleCrud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con;
	
	static {
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			// get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
