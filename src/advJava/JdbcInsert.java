package advJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsert {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {

			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");

			// create statement
			st = con.createStatement();
			
			// insert 
			int rowCount = st.executeUpdate("insert into Employee values (4,'e4', 20)");
			if (rowCount > 0) {				
				System.out.println("inserted successfully +rowCount: " + rowCount);
			}

			// write sql query
			ResultSet rs = st.executeQuery("SELECT * FROM  Employee LIMIT 5");

			printResultSet(rs);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// close statement
				st.close();

				// close connection
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public static void printResultSet(ResultSet rs) throws Exception {
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3));
		}
	}

}
