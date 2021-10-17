package advJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPrintTable {

	public static void main(String[] args) {
		try {
			
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// get connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");
			
			// create statement
			Statement st = con.createStatement();
			
			// create reader and take table name as dynamic input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Table name: ");
			String tableName = br.readLine();
			
			// write sql query			
			ResultSet rs =  st.executeQuery("SELECT * FROM " + tableName + " LIMIT 5");
			
			JdbcPrintTable.printResultSet(rs);
			
			// close statement
			st.close();
			
			// close connection
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void printResultSet(ResultSet rs) throws Exception {
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
	}

}
