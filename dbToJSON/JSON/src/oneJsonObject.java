import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class oneJsonObject {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=null;
		ArrayList<CoinDetails> a= new ArrayList<CoinDetails>();
		
	
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Crypto", "root", "Christian12!");
	    
		//object of statement to execute queries
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from CoinInfo where Location ='asia'");
    	
		
		//setting pointer to a row
	    while(rs.next()) 
	    {
	    	CoinDetails c= new CoinDetails();
	    	
	    	c.setCoinName(rs.getString(1));
	    	c.setPurchaseDate(rs.getString(2));
	    	c.setAmount(rs.getInt(3));
	    	c.setLocation(rs.getString(4));
	    	
	    	a.add(c);
	 
	    }
	    
	    for (int i = 0; i < a.size(); i++) {
		    ObjectMapper o=new ObjectMapper();
		    o.writeValue(new File("C:\\Users\\chris\\eclipse-workspace\\JSON\\coinInfo" + i + ".json"), a.get(i));
	    	
	    }
	    
	    //create json string from java object
	    
	    //add json simple
	    JSONObject jo=new JSONObject();
	    JSONArray js=new JSONArray();
	    
	    jo.put("data", js);

	    
	    
	    conn.close();
	}

}
