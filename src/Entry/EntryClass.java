package entry;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import config.JDBCConnection;
import controller.EmployeeController;
import controller.SkillController;
import controller.JobController;

public class EntryClass {
	public void testConnection() throws ClassNotFoundException, SQLException{
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//EntryClass enter=new EntryClass();
		//enter.testConnection();
		String TableName;
		Scanner s=new Scanner(System.in);
		int choice;
		char c='y';
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(c=='y' || c=='Y') {
			System.out.println("Enter the table name for performing CRUD operation(Employee/Skill/Job/EmpSkill/EmpJob): ");
			TableName=reader.readLine();
			if(TableName.equals("Employee")) {
				EmployeeController empController=new EmployeeController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Employees records");
					System.out.println("2. View single Employee record");
					System.out.println("3. Add an Employee");
					System.out.println("4. Update an Employee record");
					System.out.println("5. Deactive an Employee record");
					System.out.println("6. Delete an Employees record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Employees Details:");
							empController.getAllEmployees();
							break;
						case 2:
							empController.getEmployeeById();
							break;
						case 3:
							System.out.println("Enter Employee Detail:");
							empController.addEmployee();
							break;
						case 4:
							empController.updateEmployee();
							break;
						case 5:
							empController.deactivateEmployee();
							break;
						case 6:
							empController.DeleteEmployee();
							break;
						case 7:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			else if(TableName.equals("Skill")) {
				SkillController skillController=new SkillController();
				Scanner sc=new Scanner(System.in);
				int option;
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Skill records");
					System.out.println("2. View single Skill record");
					System.out.println("3. Add a Skill");
					System.out.println("4. Update a Skill record");
					System.out.println("5. Deactive a Skill record");
					System.out.println("6. Delete a Skill record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Skill Details:");
							skillController.getAllSkills();
							break;
						case 2:
							skillController.getSkillById();
							break;
						case 3:
							System.out.println("Enter Skill Detail:");
							skillController.addSkill();
							break;
						case 4:
							skillController.updateSkill();
							break;
						case 5:
							skillController.deactivateSkill();
							break;
						case 6:
							skillController.DeleteSkill();
							break;
						case 7:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			else if(TableName.equals("Job")) {
				JobController jobController=new JobController();
				int option;
				Scanner sc=new Scanner(System.in);
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Job records");
					System.out.println("2. View single Job record");
					System.out.println("3. Add a Job");
					System.out.println("4. Update a Job record");
					System.out.println("5. Deactive a Job record");
					System.out.println("6. Delete a Job record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Job Details:");
							jobController.getAllJobs();
							break;
						case 2:
							jobController.getJobById();
							break;
						case 3:
							System.out.println("Enter Job Detail:");
							jobController.addJob();
							break;
						case 4:
							jobController.updateJob();
							break;
						case 5:
							jobController.deactivateJob();
							break;
						case 6:
							jobController.DeleteJob();
							break;
						case 7:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			else if(TableName.equals("EmpSkill")){
				EmployeeController empskillController=new EmployeeController();
				int option;
				Scanner sc=new Scanner(System.in);
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Employee Skill records");
					System.out.println("2. View single Employee Skill record");
					System.out.println("3. Add an Employee Skill");
					System.out.println("4. Update an Employee Skill record");
					System.out.println("5. Delete an Employee Skill record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all Employee Skill Details:");
							empskillController.getAllEmpSkills();
							break;
						case 2:
							empskillController.getEmpSkillById();
							break;
						case 3:
							System.out.println("Enter Employee Skill Detail:");
							empskillController.addEmpSkill();
							break;
						case 4:
							empskillController.updateEmpSkill();
							break;
						case 5:
							empskillController.DeleteEmpSkill();
							break;
						case 6:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			else if(TableName.equals("EmpJob")) {
				EmployeeController empjobController=new EmployeeController();
				int option;
				Scanner sc=new Scanner(System.in);
				char ch='y';
				while(ch=='y' || ch=='Y') {
					System.out.println("CRUD Operation Menu:");
					System.out.println("1. View all Employee Job records");
					System.out.println("2. View single Employee Job record");
					System.out.println("3. Add an Employee Job");
					System.out.println("4. Update an Employee Job record");
					System.out.println("5. Delete an Employee Job record");
					System.out.println("Enter your choice:");
					option=sc.nextInt();
					switch(option) {
						case 1:
							System.out.println("Following are all EmpJob Details:");
							empjobController.getAllEmpJobs();
							break;
						case 2:
							empjobController.getEmpJobById();
							break;
						case 3:
							System.out.println("Enter EmpJob Detail:");
							empjobController.addEmpJob();
							break;
						case 4:
							empjobController.updateEmpJob();
							break;
						case 5:
							empjobController.DeleteEmpJob();
							break;
						case 6:
							System.exit(0);
							break;
						default:
							System.out.println("Wrong input");
					}
					System.out.println("Do you want to continue?(y/n)");
					ch=sc.next().charAt(0);
				}
			}
			System.out.println("Do you want perfom CRUD operation on other tables?(y/n)");
			c=s.next().charAt(0);
		}
	}	
}
