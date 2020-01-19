  private Boolean checkUserExists(String user) 
	   {
               UserInfo newUser = new UserInfo(user, "");

		   try {


		        	Class.forName("com.mysql.cj.jdbc.Driver");

		    		Connection conn=null;
		    		ArrayList<UserInfo> a= new ArrayList<UserInfo>();
		    		JSONArray js=new JSONArray();


		    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptoscraper", "root", "Christian12!");

		    		//object of statement to execute queries
		    		Statement st=conn.createStatement();


		    		String userQuery = "Select * from users Where username='" + newUser.getUser();
		            ResultSet rs = st.executeQuery(userQuery);
		            if (rs.next()) {
		                return true;
		            } else {
		                return false;
		            }
           }
           catch (e){

           }

       }
           