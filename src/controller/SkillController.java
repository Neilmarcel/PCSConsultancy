package controller;

import java.io.*;
import java.sql.*;
import java.util.List;
import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Skill;

public class SkillController {

	ISkillDao SkillDao=null;
	public SkillController() throws ClassNotFoundException, SQLException{
		SkillDao=new SkillDaoImpl();
	}
	
	public void addSkill() {
		Skill ski=new Skill();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Skill Name:");
			String Skill=reader.readLine();
			ski.setSkillName(Skill);
			System.out.println("Enter Skill Description:");
			ski.setSkillDescription(reader.readLine());
			
			if(Skill.equals("Leadership")) {
				ski.setActive("Active");
			}
			else {
				ski.setActive("Deactive");
			}
			//Calling dao method for insert record
			SkillDao.addSkill(ski);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getAllSkills() {
		
		List<Skill> allSkillList=SkillDao.getAllSkills();
		for(Skill ski:allSkillList) {
			System.out.println(ski);
		}
	}
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Skill ski=SkillDao.getSkillById(id);
			System.out.println(ski);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String skill, skilldescription;
			System.out.println("Enter EmployeeId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill ski=SkillDao.getSkillById(id);
			System.out.println("Enter your new Skill:");
			skill=reader.readLine();
			System.out.println("Enter your new Skill's description:");
			skilldescription=reader.readLine();
			ski.setSkillName(skill);
			ski.setSkillDescription(skilldescription);
			SkillDao.updateSkill(ski);
			System.out.println(ski);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill ski=SkillDao.getSkillById(id);
			SkillDao.deactivateSkill(ski);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			SkillDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
