package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class LoginFrame extends JFrame{

	Container container;
	JLabel lUserId, lPassword, lMessage;
	JTextField tUserId;
	JPasswordField tPassword;
	JButton bLogin, bRegister;
	EmployeeController empController=null;
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lUserId=new JLabel("USERNAME");
		lPassword=new JLabel("PASSWORD");
		lMessage=new JLabel();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		bLogin=new JButton("LOGIN");
		empController=new EmployeeController();
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				Employee emp=new Employee();
				userId=tUserId.getText();
				password=new String(tPassword.getPassword());
				emp=empController.checkLogin(userId, password);
				if(emp.getUserId()==null || emp.getPassword()==null) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"You are not authorized user! Retry or Register!");
				}
				else {
					if(emp.getActive().equals("Active")) {
						if(emp.getRole().equals("HRA")) {
							try {
								new HRAHome();
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if(emp.getRole().equals("PME")) {
							new PMEHome();
						}
						else {
							new EMPHome(emp);
						}
					}
					else {
						JFrame f=new JFrame();
						JOptionPane.showMessageDialog(f,"User not activated !...");
					}
				}	
			}
		});
		bRegister=new JButton("REGISTER");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new RegistrationFrame();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PCSC User Login");
		this.setVisible(true);
		this.setBounds(10,10,500,400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lUserId.setBounds(50, 50, 100, 30);
		lPassword.setBounds(50, 100, 100, 30);
		tUserId.setBounds(200, 50, 150, 30);
		tPassword.setBounds(200, 100, 150, 30);
		bLogin.setBounds(100, 250, 100, 30);
		bRegister.setBounds(250, 250, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(bLogin);
		container.add(bRegister);
	}
	
}