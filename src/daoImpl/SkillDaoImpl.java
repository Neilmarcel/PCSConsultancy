package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{

	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Skill> getAllSkills() {
		List<Skill> allSkillList=new ArrayList<Skill>(); //1
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Skill");
			if(rst!=null) {
				Skill emp=null;
				while(rst.next()) {
					emp=new Skill();
					emp.setSkillId(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
					allSkillList.add(emp); //2
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
	}

	@Override
	public void addSkill(Skill ski){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1, ski.getSkillName());
			pst.setString(2, ski.getSkillDescription());
			pst.setString(3, ski.getActive());
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
	public Skill getSkillById(int id) {
		Skill emp=new Skill(); //1
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp=new Skill();
					emp.setSkillId(rst.getInt(1));
					emp.setSkillName(rst.getString(2));
					emp.setSkillDescription(rst.getString(3));
					emp.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateSkill(Skill ski) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set SkillName=?,SkillDescription=? where SkillId=? ");
			pst.setString(1, ski.getSkillName());
			pst.setString(2, ski.getSkillDescription());
			pst.setInt(3, ski.getSkillId());
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
	public void deactivateSkill(Skill ski) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Deactive");
			pst.setInt(2, ski.getSkillId());
			int i=pst.executeUpdate();
			JFrame f = new JFrame();
			if(i==1){
				//System.out.println("Skill deactivated...");
				JOptionPane.showMessageDialog(f,"Skill Deactivated...");
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
	public void activateSkill(Skill ski) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, ski.getSkillId());
			int i=pst.executeUpdate();
			JFrame f = new JFrame();
			if(i==1){
				//System.out.println("Skill activated...");
				JOptionPane.showMessageDialog(f,"Skill Activated...");
			}
			else {
				JOptionPane.showMessageDialog(f,"Activation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deleteSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=? ");
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
