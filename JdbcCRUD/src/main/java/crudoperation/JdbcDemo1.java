package crudoperation;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class JdbcDemo1 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
	  // String query="insert into product_info values(5,'Charger',5600.45)";
		//String query="update product_info set product_name='Mobile' where product_id=2";
		String query="delete from product_info where product_id=3 ";
		try {
			
			//Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Establish the connection
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		  
		  //Create statement platform
			stmt=con.createStatement();
			
			//excute sql query
			int count=stmt.executeUpdate(query);
			
			//System.out.println(count+ " Record inserted");
			//System.out.println("Record Updated");
			System.out.println("Record deleted");
			
			
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
