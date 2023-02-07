package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductOperationProcedure {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int p_id=sc.nextInt();
		System.out.println("Enter Product Name");
		String pname=sc.next();
		System.out.println("Enter Product Price");
		double price=sc.nextDouble();
		System.out.println("Enter Product Id To Delete");
		int delid=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			
			cstmt=con.prepareCall("{call productoperations(?,?,?,?)}");
			
			
	     	cstmt.setInt(1, p_id);
			cstmt.setString(2, pname);
			cstmt.setDouble(3, price);
			cstmt.setInt(4, delid);
			
			cstmt.execute();
			System.out.println("Record Inserted And Deleted Successfully...");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
