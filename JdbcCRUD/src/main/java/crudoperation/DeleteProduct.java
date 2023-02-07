package crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteProduct {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();
		
		Connection con=null;
		Statement stmt=null;
		
		String query="delete from product_info where product_id="+id;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
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
