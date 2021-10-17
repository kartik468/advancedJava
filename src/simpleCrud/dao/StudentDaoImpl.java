package simpleCrud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import simpleCrud.beans.Student;
import simpleCrud.factory.ConnectionFactory;

/*
create table Student (
	sid int not null,
    sname varchar(40),
    saddr varchar(100),
    primary key (sid)
);

select * from Student;
 */

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();

			// search if student exists
			ResultSet rs = st.executeQuery("SELECT * FROM student WHERE sid = '" + std.getSid() + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "Student Exists Already";
			} else {
				// INSERET INTO student VALUES('1','kar','ad1');
				String sqlQuery = "INSERT INTO student VALUES('" + std.getSid() + "','" + std.getSname() + "','"
						+ std.getSaddr() + "')";
				System.out.println(sqlQuery);
				int rowCount = st.executeUpdate(sqlQuery);
				if (rowCount == 1) {
					status = "Student Insert success..";
				} else {
					status = "Student Insert failed..";
				}
			}

		} catch (Exception e) {
			status = "Student Insert failed..";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();

			// search if student exists
			ResultSet rs = st.executeQuery("SELECT * FROM student WHERE sid = '" + sid + "'");
			boolean b = rs.next();
			if (b == true) {
				std = new Student();
				std.setSid(rs.getString("sid"));
				std.setSname(rs.getString("sname"));
				std.setSaddr(rs.getString("saddr"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String update(Student std) {

		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();

			// INSERET INTO student VALUES('1','kar','ad1');
			String sqlQuery = "UPDATE student SET sname='" + std.getSname() + "', saddr='" + std.getSaddr() + "' WHERE sid='" + std.getSid() + "'";
			System.out.println(sqlQuery);
			int rowCount = st.executeUpdate(sqlQuery);
			if (rowCount == 1) {
				status = "Student update success..";
			} else {
				status = "Student update failed..";
			}

		} catch (Exception e) {
			status = "Student update failed..";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {

		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();

			// INSERET INTO student VALUES('1','kar','ad1');
			String sqlQuery = "DELETE FROM STUDENT WHERE sid='" + sid + "'";;
			System.out.println(sqlQuery);
			int rowCount = st.executeUpdate(sqlQuery);
			if (rowCount == 1) {
				status = "Student update success..";
			} else {
				status = "Student update failed..";
			}

		} catch (Exception e) {
			status = "Student update failed..";
			e.printStackTrace();
		}
		return status;
	}

}
