package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao{

	Connection conn=null;
	public EmpJobDaoImpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpJob> getAllEmpJobs() {
		List<EmpJob> allEmpJobList=new ArrayList<EmpJob>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpJob");
			if(rst!=null) {
				EmpJob ejb=null;
				while(rst.next()) {
					ejb=new EmpJob();
					ejb.setEJId(rst.getInt(1));
					ejb.setEmpId(rst.getInt(2));
					ejb.setJobId(rst.getInt(3));
					ejb.setRecruited(rst.getString(4));
					allEmpJobList.add(ejb); //2
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;
	}

	@Override
	public void addEmpJob(EmpJob esk){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into EmpJob(Recruited) values(?)");
			pst.setString(1, esk.getRecruited());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public EmpJob getEmpJobById(int id) {
		EmpJob ejb=new EmpJob(); //1
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpJob where EJId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					ejb=new EmpJob();
					ejb.setEJId(rst.getInt(1));
					ejb.setEmpId(rst.getInt(2));
					ejb.setJobId(rst.getInt(3));
					ejb.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return ejb;
	}

	@Override
	public void updateEmpJob(EmpJob ejb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=? ");
			pst.setString(1, ejb.getRecruited());
			pst.setInt(2, ejb.getEJId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("update failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deleteEmpJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
