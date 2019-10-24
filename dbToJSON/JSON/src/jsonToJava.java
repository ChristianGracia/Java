import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jsonToJava {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=null;
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "Christian12!");
	    
		//object of statement to execute queries
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from CustomerInfo where Location ='asia' LIMIT 1");
		
		//setting pointer to a row
	    while(rs.next()) 
	    {
	    	
	    	CoinDetails c= new CoinDetails();
	    	
	    	c.setCourseName(rs.getString(1));
	    	c.setPurchaseDate(rs.getString(2));
	    	c.setAmount(rs.getInt(3));
	    	c.setLocation(rs.getString(4));
	 
	    }
	    conn.close();
	}

}
