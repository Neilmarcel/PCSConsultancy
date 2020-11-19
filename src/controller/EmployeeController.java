package controller;

import java.io.*;
import java.sql.SQLException;
import model.Employee;
import java.util.List;
import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;

public class EmployeeController {
    
	IEmployeeDao empDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException {
		empDao=new EmployeeDaoImpl();
	}
	public void addEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter First Name:");
			emp.setFirstName(reader.readLine());
			System.out.println("Enter Last Name:");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserId:");
			emp.setUserId(reader.readLine());
			System.out.println("Enter Password:");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Role:");
			String role=reader.readLine();
			emp.setRole(role);
			System.out.println("Enter Gender:");
			emp.setGender(reader.readLine());
			if(role.equals("HRA")) {
				emp.setActive("Active");
			}
			else {
				emp.setActive("Deactive");
			}
			//Calling dao method for insert record
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void getAllEmployees() {
		List<Employee> allEmpList=empDao.getAllEmployees();
		//Iterator itr=allEmpList.iterator();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
}