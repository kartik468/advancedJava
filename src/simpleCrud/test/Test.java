package simpleCrud.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import simpleCrud.beans.Student;
import simpleCrud.factory.StudentServiceFactory;
import simpleCrud.service.StudentService;

// controller layer
public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("1: Add");
				System.out.println("2: Search");
				System.out.println("3: Update");
				System.out.println("4: Delete");
				System.out.println("5: Exit");

				System.out.println("Your Option [1,2,3,4,5]: ");

				int option = Integer.parseInt(br.readLine());
				
				String sid = "";
				String sname = "";
				String saddr = "";
				
				Student std = null;
				
				StudentService studentService = StudentServiceFactory.getStudentService();

				switch (option) {
				case 1:
					// Add
					System.out.println("Student Id: ");
					sid = br.readLine();
					
					System.out.println("Student Name: ");
					sname = br.readLine();
					
					System.out.println("Student address: ");
					saddr = br.readLine();
					
					std = new Student();
					std.setSname(sname);;
					std.setSid(sid);
					std.setSaddr(saddr);
					
					String status = studentService.addStudent(std);
					
					System.out.println("Status: " + status);
					
					break;
				case 2:
					// Search
					System.out.println("Student Id: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					
					if (std == null) {
						System.out.println("Status: Student does not exists");
					} else {
						System.out.println("Status: Student exists");
						System.out.println(std.toString());
					}
					
					break;
				case 3:
					// update
					
					// Search first
					System.out.println("Student Id: ");
					sid = br.readLine();
					Student oldStd = studentService.searchStudent(sid);
					
					if (oldStd == null) {
						System.out.println("Status: Student does not exists");
					} else {
						System.out.println("old student: " + oldStd.toString());
						
						sid = oldStd.getSid();
						
						System.out.println("Student Name: ");
						sname = br.readLine();
						if (sname == null || sname.equals("")) {
							sname = oldStd.getSname();
						}
						
						System.out.println("Student address: ");
						saddr = br.readLine();
						if (saddr == null || saddr.equals("")) {
							saddr = oldStd.getSaddr();
						}
						
						std = new Student();
						std.setSname(sname);;
						std.setSid(sid);
						std.setSaddr(saddr);
						
						System.out.println(std.toString());
						
						String updateStatus = studentService.updateStudent(std);
						System.out.println("Status: " + updateStatus);
					}
					break;
					
				case 4:
					
					// Delete

					// Search first
					System.out.println("Student Id: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					
					if (std == null) {
						System.out.println("Status: Student does not exists");
					} else {
						System.out.println("Status: Student exists");
						System.out.println(std.toString());
						
						String deleteStaus = studentService.deleteStudent(sid);
						System.out.println("Status: " + deleteStaus);
					}
					break;
				case 5:
					// exit
					System.out.println("Exiting application");
					System.exit(0);
					break;
				default:
					System.out.println("Provide number from 1 to 5");
					break;
				}
				
				System.out.println("====================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
