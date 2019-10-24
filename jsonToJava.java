import java.sql.Connection;
import java.sql.DriverManager;

public class jsonToJava {
	public static void main(string[] args) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=null;
		DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Christian12!");
	    
		//object of statement to execute queries
		conn.createStatement()
	}

}
