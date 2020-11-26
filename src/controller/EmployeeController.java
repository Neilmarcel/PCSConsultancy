package controller;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;
import dao.IEmpSkillDao;
import daoImpl.EmpSkillDaoImpl;
import model.EmpSkill;
import dao.IEmpJobDao;
import daoImpl.EmpJobDaoImpl;
import model.EmpJob;

public class EmployeeController {

	IEmployeeDao empDao=null;
	IEmpSkillDao empskillDao=null;
	IEmpJobDao empjobDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDaoImpl();
		empskillDao=new EmpSkillDaoImpl();
		empjobDao=new EmpJobDaoImpl();
	}
	public Employee checkLogin(String userId,String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
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
			empDao.addEmployee(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
	public void getEmployeeById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println(emp);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
		}
		public void updateEmployee() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				String password, confirmpassword;
				System.out.println("Enter EmployeeId whose record you want to update:");
				id=Integer.parseInt(reader.readLine());
				Employee emp=empDao.getEmployeeById(id);
				System.out.println("Enter your new password:");
				password=reader.readLine();
				System.out.println("re-enter same password to confirm:");
				confirmpassword=reader.readLine();
				if(password.contentEquals(confirmpassword)) {
					emp.setPassword(password);
					empDao.updateEmployee(emp);
				}
				else {
					System.out.println("Sorry! you have entered different password");
				}
				System.out.println(emp);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void deactivateEmployee() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EmployeeId whose record you want to deactivate:");
				id=Integer.parseInt(reader.readLine());
				Employee emp=empDao.getEmployeeById(id);
				empDao.deactivateEmployee(emp);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void DeleteEmployee() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EmployeeId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				empDao.deleteEmployee(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void addEmpSkill() {
			EmpSkill esk=new EmpSkill();
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter year of Expiry:");
			esk.setExpYear(sc.nextInt());
			empskillDao.addEmpSkill(esk);
		}
		public void getAllEmpSkills() {
			
			List<EmpSkill> allEmpSkillList=empskillDao.getAllEmpSkills();
			for(EmpSkill esk:allEmpSkillList) {
				System.out.println(esk);
			}
		}
		public void getEmpSkillById() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EmpSkillId whose record you want to access:");
				id=Integer.parseInt(reader.readLine());
				EmpSkill esk=empskillDao.getEmpSkillById(id);
				System.out.println(esk);
				}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
				}
		}
		public void updateEmpSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				Scanner sc=new Scanner(System.in);
				int id;
				int expyear;
				System.out.println("Enter ESId whose record you want to update:");
				id=Integer.parseInt(reader.readLine());
				EmpSkill esk=empskillDao.getEmpSkillById(id);
				System.out.println("Enter your new Expiry Year:");
				expyear=sc.nextInt();
				esk.setExpYear(expyear);
				empskillDao.updateEmpSkill(esk);
				System.out.println(esk);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void DeleteEmpSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter ESId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				empskillDao.deleteEmpSkill(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void addEmpJob() {
			EmpJob ejb=new EmpJob();
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter whether recruited or not :");
				ejb.setRecruited(reader.readLine());
				empjobDao.addEmpJob(ejb);
			}
			catch(IOException ex){
				System.out.println(ex.getMessage());
			}
		}
public void getAllEmpJobs() {
			
			List<EmpJob> allEmpJobList=empjobDao.getAllEmpJobs();
			for(EmpJob ejb:allEmpJobList) {
				System.out.println(ejb);
			}
		}
		public void getEmpJobById() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EmpJobId whose record you want to access:");
				id=Integer.parseInt(reader.readLine());
				EmpJob ejb=empjobDao.getEmpJobById(id);
				System.out.println(ejb);
				}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
				}
		}
		public void updateEmpJob() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				String recruited;
				System.out.println("Enter EJId whose record you want to update:");
				id=Integer.parseInt(reader.readLine());
				EmpJob ejb=empjobDao.getEmpJobById(id);
				System.out.println("Enter your new recruited info:");
				recruited=reader.readLine();
				ejb.setRecruited(recruited);
				empjobDao.updateEmpJob(ejb);
				System.out.println(ejb);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void DeleteEmpJob() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter EJId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				empjobDao.deleteEmpJob(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
}