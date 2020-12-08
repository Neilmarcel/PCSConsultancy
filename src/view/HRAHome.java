package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;
import model.Employee;

public class HRAHome extends JFrame {
	Container container;
	JLabel lTitle,lEmpId;
	JTextField tEmpId,tdata;
	JButton bSetActive,bSetDeactive,bViewAllEmp,bViewSelectiveEmp,bViewSkill,bSetDeactiveSkill,bLogout;
	JFrame f;
	EmployeeController empController=null;
	JobController jobController=null;
	SkillController skillController=null;
	
	public HRAHome() throws ClassNotFoundException, SQLException {
		
		container=getContentPane();
		empController=new EmployeeController();
		jobController=new JobController();
		skillController=new SkillController();
		lTitle=new JLabel("Welcome to HRA Portal!");
		tEmpId=new JTextField();
		bSetActive=new JButton("Activate User");
		bSetActive.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					 new ActivateFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		bSetDeactive=new JButton("Deactivate User");
		bSetDeactive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

			}	
		});
		
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				empController.getAllEmployees();
			}
		});
		
		bViewSelectiveEmp=new JButton("View selective Employees");
		bViewSelectiveEmp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

			}	
		});
		
		
		
		bViewSkill=new JButton("View all Skills");
		bViewSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bSetDeactiveSkill=new JButton("Deactivate Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	public void setLocationAndSize() {
		lTitle.setBounds(50, 50, 500, 60);
		lTitle.setFont(getFont());;
		bSetActive.setBounds(150,150,200,30);
		bSetDeactive.setBounds(150,200,200,30);
		bViewAllEmp.setBounds(150,250,200,30);
		bViewSelectiveEmp.setBounds(150,300,200,30);
		bViewSkill.setBounds(150,350,200,30);
		bSetDeactiveSkill.setBounds(150,400,200,30);
		bLogout.setBounds(150,450,200,30);
	}

	public void setLayoutManager() {
		container.add(lTitle);
		container.add(bSetActive);	
		container.add(bSetDeactive);	
		container.add(bViewAllEmp);	
		container.add(bViewSelectiveEmp);
		container.add(bViewSkill);	
		container.add(bSetDeactiveSkill);	
		container.add(bLogout);	
	
	}

}
