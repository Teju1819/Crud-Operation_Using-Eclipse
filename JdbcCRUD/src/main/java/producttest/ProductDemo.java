package producttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemo 
{
	static Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void maxPrice()
	{
		String query="select *  from product_info where product_price=(select max(product_price) from product_info)";
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
	public void minPrice()
	{
		String query="select *  from product_info where product_price=(select min(product_price) from product_info)";
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
