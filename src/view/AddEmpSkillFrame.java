package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EmployeeController;

public class AddEmpSkillFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Container container;
	JLabel lExpYear,lEmployeeId,lSkillId;
	JTextField tExpYear,tEmployeeId,tSkillId;
	JButton bSubmit;
	EmployeeController empController=null;
	JFrame f;
	public AddEmpSkillFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		empController=new EmployeeController();
		lExpYear=new JLabel("Expiry Year");
		lEmployeeId=new JLabel("Employee ID");
		lSkillId=new JLabel("Skill ID");
		tExpYear=new JTextField();
		tEmployeeId=new JTextField();
		tSkillId=new JTextField();
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int s1,s2,s3;
				s3=Integer.parseInt(tExpYear.getText());
				s1=Integer.parseInt(tEmployeeId.getText());
				s2=Integer.parseInt(tSkillId.getText());
				empController.addEmpSkill(s1, s2,s3);
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Add Employee Skill");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(50, 150, 100, 30);
		lSkillId.setBounds(50, 250, 100, 30);
		lExpYear.setBounds(50, 350, 100, 30);
		
		tEmployeeId.setBounds(200, 150, 150, 30);
		tSkillId.setBounds(200, 250, 150, 30);
		tExpYear.setBounds(200, 350, 150, 30);
		
		bSubmit.setBounds(100, 500, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(tSkillId);
		container.add(lSkillId);
		container.add(lExpYear);
		container.add(lSkillId);
		container.add(tExpYear);
		container.add(bSubmit);
		
	}
}
