package crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="Select * from product_info";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
