package DBHotel;

import java.sql.*;

public class DBConnector {
	
	public java.sql.Connection con;
	private String url = "jdbc:mysql://localhost/";
	private String dbname = "hotel";
	private String username = "root";
	private String password = "";
	
	
	public void setConnection()throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url+dbname,username,password);
	}
	
	
	public boolean getConnectionStatues(){
		
		if(con != null)
			return true;
		
		else
			return false;
  }
	

    public java.sql.Connection getConnection(){
	
		return con;
   }

 }
