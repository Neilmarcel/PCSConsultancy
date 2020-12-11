package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import model.Employee;

public class EMPHome extends JFrame{
	Container container=null;
	JLabel lTitle;
	JButton bViewProfile,bUpdateProfile,bUpdateSkill,bApplyJob,bLogout;
	public EMPHome(Employee emp) {
		container=getContentPane();
		lTitle=new JLabel(" Welcome "+emp.getFirstName()+" !");
		bViewProfile=new JButton("View Profile");
		bViewProfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int s=emp.getEmpId();
					new EmpProfileFrame(s);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		bUpdateProfile=new JButton("Update Profile");
		bUpdateProfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ChangePasswordFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		bUpdateSkill=new JButton("Add Skill");
		bUpdateSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddEmpSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		bApplyJob=new JButton("Apply Job");
		bApplyJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ApplyJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		bLogout=new JButton("Sign out");
		bLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Logout();
			}	
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("EMP Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void Logout(){
		this.dispose();
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lTitle.setBounds(50, 80, 300, 30);
		bViewProfile.setBounds(50, 150, 300, 30);
		bUpdateProfile.setBounds(50, 200, 300, 30);
		bUpdateSkill.setBounds(50, 250, 300, 30);
		bApplyJob.setBounds(50, 300, 300, 30);
		bLogout.setBounds(50, 350, 300, 30);
	}
	public void addComponentsToContainer() {
		container.add(lTitle);
		container.add(bViewProfile);
		container.add(bUpdateProfile);
		container.add(bUpdateSkill);
		container.add(bApplyJob);
		container.add(bLogout);
	}
}
