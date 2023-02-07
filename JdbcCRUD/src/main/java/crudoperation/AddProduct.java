package crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddProduct {

	public static void main(String[] args) {
		
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();
		
		System.out.println("Enter Product Name");
		String name=sc1.next();
		
		System.out.println("Enter Product Price");
	    double price=sc1.nextDouble();		
    
		Connection con=null;
		Statement stmt=null;
		
		String query="insert into product_info values("+id+",'"+name+"',"+price+")";
		
		//String query="insert into product_info values("+id+",'"+name+"', "+Price+")";
		
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+" Product inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally {
			 if(con!=null) {
				 try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 }
		 }
		
		
	}

}
