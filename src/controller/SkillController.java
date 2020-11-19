package controller;

import java.io.*;
import java.sql.SQLException;
import model.Skill;
import java.util.List;
import dao.ISkillDao;
import daoImpl.SkillDaoImpl;

public class SkillController {
    
	SkillDaoImpl skillDao=null;
	public SkillController() throws ClassNotFoundException, SQLException {
		skillDao=new SkillDaoImpl();
	}
	public void addSkill() {
		Skill ski=new Skill();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Skill Name:");
			ski.setSkillName(reader.readLine());
			System.out.println("Enter Skill Description:");
			ski.setSkillDescription(reader.readLine());
			System.out.println("Enter UserId:");
			emp.setUserId(reader.readLine());
			System.out.println("Enter Password:");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Role:");
			String =reader.readLine();
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
	public void getAllSkills() {
		List<Skill> allSkillList=ski.getAllSkills();
		//Iterator itr=allEmpList.iterator();
		for(Skill emp:allSkillList) {
			System.out.println(ski);
		}
	}
}