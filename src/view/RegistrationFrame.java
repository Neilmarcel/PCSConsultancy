package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import controller.EmployeeController;

public class RegistrationFrame extends JFrame  {

	private static final long serialVersionUID = 1L;
	Container container;
	JFrame f;
	JLabel lFirstname,lLastname,lUserId,lPassword,lconfirmPassword,lGender,lRole;
	JTextField tFirstname,tLastname,tUserId,tGender,tRole;
	JPasswordField tPassword,tconfirmPassword;
	JButton bSubmit;
	EmployeeController empController=null;

	public RegistrationFrame()throws ClassNotFoundException, SQLException {
		container=getContentPane();
		f=new JFrame();
		lFirstname=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lUserId=new JLabel("User Id");
		lPassword=new JLabel("Create Password");
		lconfirmPassword=new JLabel("Confirm Password");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		tconfirmPassword=new JPasswordField();
		tGender=new JTextField();
		tRole=new JTextField();
		bSubmit=new JButton("SUBMIT");
		empController=new EmployeeController();
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2,s3,s4,s5,s6,s7;
				s1=tFirstname.getText();
				s2=tLastname.getText();
				s3=tUserId.getText();
				s4=new String(tPassword.getPassword());
				s5=tRole.getText();
				s6=tGender.getText();
				s7=new String(tconfirmPassword.getPassword());
				if(s4.equals(s7))
				{
					f=new JFrame();
					empController.addEmployee(s1,s2,s3,s4,s5,s6);
					JOptionPane.showMessageDialog(f,"Register Sucessfuly!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Oops! Password do not match,Retry!");
				}
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lFirstname.setBounds(30, 150, 100, 30);
		lLastname.setBounds(30, 200, 100, 30);
		lUserId.setBounds(30, 250, 100, 30);
		lPassword.setBounds(30, 300, 100, 30);
		lconfirmPassword.setBounds(30,350,200,30);
		lGender.setBounds(30, 400, 100, 30);
		lRole.setBounds(30, 450, 150, 30);
		
		
		tFirstname.setBounds(300, 150, 150, 30);
		tLastname.setBounds(300,200,150,30);
		tUserId.setBounds(300, 250, 150, 30);
		tPassword.setBounds(300,300,150,30);
		tconfirmPassword.setBounds(300,350,150,30);
		tGender.setBounds(300, 400, 150, 30);
		tRole.setBounds(300, 450, 150, 30);
		bSubmit.setBounds(100, 550, 150, 30);
	}
	public void addComponentsToContainer() {
		container.add(lFirstname);
		container.add(tFirstname);
		container.add(lLastname);
		container.add(tLastname);
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(lconfirmPassword);
		container.add(tconfirmPassword);
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		container.add(bSubmit);
	}
	

}