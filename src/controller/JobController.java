package controller;

import java.io.*;
import java.sql.*;
import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {

	IJobDao JobDao=null;
	public JobController() throws ClassNotFoundException, SQLException{
		JobDao=new JobDaoImpl();
	}
	
	public void addJob(String s1, String s2, String s3, String s4, String s5, String s6) {
		Job jb=new Job();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Job Title:");
		//String Job=reader.readLine();
		jb.setJobTitle(s1);
		//System.out.println("Enter Job Description:");
		//jb .setJobDescription(reader.readLine());
		jb .setJobDescription(s2);
		//System.out.println("Enter Company Name:");
		//jb.setCompanyName(reader.readLine());
		jb.setCompanyName(s3);
		//System.out.println("Enter Location:");
		//jb.setLocation(reader.readLine());
		jb.setLocation(s4);
		//System.out.println("Enter Key skill:");
		//jb.setKeySkill(reader.readLine());
		jb.setKeySkill(s5);
		System.out.println("Enter Salary:");
		//jb.setSalary(reader.readLine());
		jb.setSalary(s6);
		if(s1.equals("HR")) {
			jb.setActivate("Activated");
		}
		else {
			jb.setActivate("Deactivated");
		}
		//Calling dao method for insert record
		JobDao.addJob(jb);
	}
	
	public void getAllJobs() {
		
		List<Job> allJobList=JobDao.getAllJobs();
		for(Job jb:allJobList) {
			System.out.println(jb);
		}
	}
	public void getJobById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmployeeId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Job jb=JobDao.getJobById(id);
			System.out.println(jb);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
		}
	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String location, confirmlocation;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job jb=JobDao.getJobById(id);
			System.out.println("Enter your new location:");
			location=reader.readLine();
			System.out.println("re-enter same Location to confirm:");
			confirmlocation=reader.readLine();
			if(location.contentEquals(confirmlocation)) {
				jb.setLocation(location);
				JobDao.updateJob(jb);
			}
			else {
				System.out.println("Sorry! you have entered different location");
			}
			System.out.println(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Job jb=JobDao.getJobById(id);
			JobDao.deactivateJob(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			JobDao.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
