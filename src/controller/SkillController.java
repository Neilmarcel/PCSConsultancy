package controller;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
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
	
	public void getAllEmployees() {
		
		List<Skill> allSkillList=SkillDao.getAllSkills();
		for(Skill ski:allSkillList) {
			System.out.println(ski);
		}
	}
	
}
