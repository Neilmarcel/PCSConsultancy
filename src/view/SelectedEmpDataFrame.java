package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.EmpbyIdFrame;

import config.JDBCConnection;

public class SelectedEmpDataFrame extends JFrame {
	JFrame frame;
	Container container;
	public SelectedEmpDataFrame(int s) throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		EmpbyIdFrame empbyid=new EmpbyIdFrame();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EmployeeId", "FirstName", "LastName", "Role","Gender", "Active"}, 0);
		PreparedStatement pst=conn.prepareStatement("select * from Employee where EmployeeId=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
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
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.setLayout(null);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Selected Employee Data");
		}
	}
}
