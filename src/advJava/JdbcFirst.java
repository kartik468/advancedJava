package advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {			
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// get connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");
			
			// create statement
			Statement st = con.createStatement();
			
			// execute query
			ResultSet rs = st.executeQuery("SELECT * FROM CITY LIMIT 5");
			
			// print rs
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			// close statement and connection
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	

	}

}

/*
create table employee (
	id int not null,
    name varchar(40),
    salary float,
    primary key (id)
);
*/