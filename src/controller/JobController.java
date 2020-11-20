package controller;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {

	IJobDao JobDao=null;
	public JobController() throws ClassNotFoundException, SQLException{
		JobDao=new JobDaoImpl();
	}
	
	public void addJob() {
		Job jb=new Job();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Job Title:");
			String Job=reader.readLine();
			jb.setJobTitle(Job);
			System.out.println("Enter Job Description:");
			jb .setJobDescription(reader.readLine());
			System.out.println("Enter Company Name:");
			jb.setCompanyName(reader.readLine());
			System.out.println("Enter Location:");
			jb.setLocation(reader.readLine());
			System.out.println("Enter Key skill:");
			jb.setKeySkill(reader.readLine());
			
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
