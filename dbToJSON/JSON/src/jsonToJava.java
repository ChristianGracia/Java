import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonToJava {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=null;
		CoinDetails c= new CoinDetails();
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "Christian12!");
	    
		//object of statement to execute queries
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from CustomerInfo where Location ='asia' LIMIT 1");
    	
		
		//setting pointer to a row
	    while(rs.next()) 
	    {
	    	c.setCourseName(rs.getString(1));
	    	c.setPurchaseDate(rs.getString(2));
	    	c.setAmount(rs.getInt(3));
	    	c.setLocation(rs.getString(4));
	 
	    }
	    
	    ObjectMapper o=new ObjectMapper();
	    o.writeValue(new File("C:\\Users\\chris\\eclipse-workspace\\JSON\\coinInfo.json"), c);
	    
	    
	    conn.close();
	}

}
