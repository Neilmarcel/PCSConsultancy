package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
			PreparedStatement pst=conn.prepareStatement("insert into Employee(SkillName,SkillDescription,Active) values(?,?,?)");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSkill(Skill ski) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateSkill(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
