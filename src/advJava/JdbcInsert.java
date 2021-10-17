package advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsert {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");

			// create statement
			st = con.createStatement();
			
			// insert 
			int rowCount = st.executeUpdate("INSERT INTO Employee VALUES (5,'e5', 20)");
			if (rowCount > 0) {				
				System.out.println("inserted successfully +rowCount: " + rowCount);
			}

			// write sql query
			rs = st.executeQuery("SELECT * FROM  Employee LIMIT 5");

			printResultSet(rs);
//			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
