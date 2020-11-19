package daoImpl;
import java.sql.ResultSet;
import java.sql.Statement;

import config.JDBCConnection;
import dao.IEmployeeDao;
import model.Employee;
public class EmployeeDao implements IEmployeeDao {
	
	Connection conn=null;
	public EmployeeDao() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnecton();
	}
	@Override
	public void getAllEmployees() {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			if(rst!=null) {
				Employee emp=new Employee();
				while(rst.next()) {
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2))
				}
			}
		}
		
	}

	@Override
	public void addEmployee(Employee emp){
		try {
		PreparedStatement pst=conn.prepareStatement("Insert int Employee values(?,?,?,?,?,?,?)");
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		pst.setString(1,emp.getFirstName());
		if(i==1) {
			
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	

}
