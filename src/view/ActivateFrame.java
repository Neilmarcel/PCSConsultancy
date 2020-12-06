package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.EmployeeController;

public class ActivateFrame extends JFrame{

	Container container;
	JFrame f;
	JLabel lEmployeeId;
	JTextField tEmployeeId;
	JButton bActivate;
	EmployeeController empController=null;
	
	public ActivateFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lEmployeeId=new JLabel("Employee ID");
		tEmployeeId=new JTextField();
		bActivate=new JButton("ACTIVATE");
		empController=new EmployeeController();
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=tEmployeeId.getColumns();
				f=new JFrame();
				empController.activateEmployee(s);
				JOptionPane.showMessageDialog(f,"Employee Activated...");
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lEmployeeId.setBounds(30, 150, 100, 30);
	}

	private void addComponentsToContainer() {
		tEmployeeId.setBounds(300, 150, 150, 30);
	}
}
