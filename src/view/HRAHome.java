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
	JList list;
	DefaultListModel<List<Employee>> listmodel;
	JButton bSetActive,bSetDeactive,bViewAllEmp,bViewSelectiveEmp,bAddSkill,bViewSkill,bSetDeactiveSkill,bLogout;
	JFrame f;
	EmployeeController empController=null;
	JobController jobController=null;
	SkillController skillController=null;
	
	public HRAHome() throws ClassNotFoundException, SQLException {
		
		container=getContentPane();
		empController=new EmployeeController();
		jobController=new JobController();
		skillController=new SkillController();
		Employee emp=new Employee();
		lTitle=new JLabel("Welcome to HRA Portal");
		tEmpId=new JTextField();

		bSetActive=new JButton("Activate User");
		bSetActive.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ActivateFrame();
				} catch (ClassNotFoundException | SQLException e1) {
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
				empController.getEmployeeById();
			}	
		});
		
		bAddSkill=new JButton("Add Skill");
		bAddSkill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						 new AddSkillFrame();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
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
				try {
					new LoginFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void addComponentsToContainer() {
		container.setLayout(null);
		
	}

	public void setLocationAndSize() {
		lTitle.setBounds(150, 100, 300, 30);
		bSetActive.setBounds(50,150,300,30);
		bSetDeactive.setBounds(50,200,300,30);
		bViewAllEmp.setBounds(50,250,300,30);
		bViewSelectiveEmp.setBounds(50,300,300,30);
		bAddSkill.setBounds(50,350,300,30);
		bViewSkill.setBounds(50,400,300,30);
		bSetDeactiveSkill.setBounds(50,450,300,30);
		bLogout.setBounds(50,500,300,30);
		lEmpId.setBounds(50, 80, 300, 30);
		tEmpId.setBounds(200, 150, 150, 30);
		
	}

	public void setLayoutManager() {
		container.add(lTitle);
		container.add(bSetActive);	
		container.add(bSetDeactive);	
		container.add(bViewAllEmp);	
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);	
		container.add(bViewSkill);	
		container.add(bSetDeactiveSkill);	
		container.add(bLogout);	
		container.add(lEmpId);
		container.add(tEmpId);
		
	}

}
