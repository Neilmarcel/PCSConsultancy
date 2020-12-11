package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao{

	Connection conn=null;
	public JobDaoImpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job jb=null;
				while(rst.next()) {
					jb=new Job();
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setCompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setKeySkill(rst.getString(6));
					jb.setSalary(rst.getString(7));
					jb.setActivate(rst.getString(8));
					allJobList.add(jb); //2
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}

	@Override
	public void addJob(Job jb){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Job(JobTitle, JobDescription,CompanyName,Location,KeySkill,Salary,Activate) values(?,?,?,?,?,?,?)");
			pst.setString(1, jb.getJobTitle());
			pst.setString(2, jb.getJobDescription());
			pst.setString(3, jb.getCompanyName());
			pst.setString(4, jb.getLocation());
			pst.setString(5, jb.getKeySkill());
			pst.setString(6, jb.getSalary());
			pst.setString(7, jb.getActivate());
			int i=pst.executeUpdate();
			JFrame f=new JFrame();
			if(i==1){
				//System.out.println("1 record inserted...");
				JOptionPane.showMessageDialog(f,"Job Added");
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
	public Job getJobById(int id) {
		Job jb=new Job(); //1
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Job where JobId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					jb=new Job();
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setCompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setKeySkill(rst.getString(6));
					jb.setSalary(rst.getString(7));
					jb.setActivate(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return jb;
	}

	@Override
	public void updateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Location=? where JobId=? ");
			pst.setString(1, jb.getLocation());
			pst.setInt(2, jb.getJobId());
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
	public void deactivateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Activate=? where JobId=? ");
			pst.setString(1, "Deactive");
			pst.setInt(2, jb.getJobId());
			int i=pst.executeUpdate();
			JFrame f = new JFrame();
			if(i==1){
				//System.out.println("Job deactivated...");
				JOptionPane.showMessageDialog(f,"Job Deactivated...");
			}
			else {
				//System.out.println("Deactivation failed...");
				JOptionPane.showMessageDialog(f,"Deactivation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void activateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Activate=? where JobId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, jb.getJobId());
			int i=pst.executeUpdate();
			JFrame f = new JFrame();
			if(i==1){
				//System.out.println("Job activated...");
				JOptionPane.showMessageDialog(f,"Job Activated...");
			}
			else {
				//System.out.println("Activation failed...");
				JOptionPane.showMessageDialog(f,"Activation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=? ");
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
