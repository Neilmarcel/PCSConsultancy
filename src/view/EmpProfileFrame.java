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

import config.JDBCConnection;

public class EmpProfileFrame extends JFrame {
	JFrame frame;
	Container container;
	public EmpProfileFrame(int s) throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		EmpbyIdFrame empbyid=new EmpbyIdFrame();
		PreparedStatement pst=conn.prepareStatement("select * from Employee where EmployeeId=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		    int a = rst.getInt("EmployeeId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Role");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Active");
		    container=getContentPane();   
		    container.setLayout(null);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Selected Employee Data");
		}
	}
}
