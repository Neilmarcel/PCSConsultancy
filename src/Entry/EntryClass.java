package Entry;
import java.sql.SQLException;
import config.JDBCConnection;
public class EntryClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("System is closed");
		}
		else {
			System.out.println("System is open");
		}

	}

}
