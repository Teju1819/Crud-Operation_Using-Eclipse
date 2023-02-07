package crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateProduct {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();
		
		System.out.println("Enter Updated Price");
		double price1=sc1.nextDouble();
		Connection con=null;
		Statement stmt=null;
		
		String query="update product_info set product_price="+price1 +"where product_id="+id;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println("Price Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
