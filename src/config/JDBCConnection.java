package config;

import java.sql.*;

public class JDBCConnection {

		public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
			//DataSourse information
			String url="jdbc:mysql://localhost:3306//pcsdb";
			String username="root";
			String password="nmj@1234567";
			//Loading Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Creating connection object
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}
}