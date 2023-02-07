package productoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductSimulator {
	static Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	static
	{
		
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	public void addProduct(int id , String name, double price)
	{
		String query="insert into product_info values("+id+",'"+name+"',"+price+")";
		try {
			stmt=con.createStatement();
			
			int count = stmt.executeUpdate(query);
			System.out.println(count+" Product inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	public void deleteProduct(int id)
	{
		String query="delete from product_info where product_id="+id;
		try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			if(count!=0)
			{
				System.out.println(count+"Product Deleted");
			}
			else
			{
			System.out.println("Product Not Found");
			}
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void displayProduct()
	{
	
		String query="Select * from product_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("ID\t\tNAME\t\tPRICE");
			System.out.println("====================================================");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			} 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
}
}