package view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import config.JDBCConnection;

public class AllEmployeesFrame extends JFrame {
	JFrame frame;
	Container container;
	public AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EmployeeId", "FirstName", "LastName", "Role","Gender", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Employee");
		model.addRow(new String[]{"EmployeeId", "FirstName", "LastName", "Role","Gender", "Active"});
		while(rst.next())
		{
		    int a = rst.getInt("EmployeeId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Role");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Active");
		    model.addRow(new Object[]{a,b,c,d,e,f});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Employee Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
}
