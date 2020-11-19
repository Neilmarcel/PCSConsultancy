package config;
import java.sql.*;

public class JDBCConnection {

		public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
			String url="jdbc:sqlserver://MSSQLSERVER01;database=PCSDB";
			String username="sa";
			String password="niit@123";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}
}

