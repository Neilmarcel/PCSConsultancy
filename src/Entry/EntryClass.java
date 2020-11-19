package Entry;

import java.sql.SQLException;

import config.JDBCConnection;
import controller.EmployeeController;

public class EntryClass {
	public void testConnection() throws ClassNotFoundException, SQLException{
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EntryClass entr=new EntryClass();
		entr.testConnection();
		EmployeeController empController=new EmployeeController();
		System.out.println("Enter the details of Employees: ");
		empController.addEmployee();
		System.out.println("Displaying the details of Employees: ");
		empController.getAllEmployees();

	}

}