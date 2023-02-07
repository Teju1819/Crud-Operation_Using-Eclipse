package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class BikeOperationProcedure {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bike Id");
		int bike_id=sc.nextInt();
		System.out.println("Enter Bike Model");
		String model=sc.next();
		System.out.println("Enter Bike Company");
		String company=sc.next();
		System.out.println("Enter Bike Price");
		Double price=sc.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
             cstmt=con.prepareCall("{call bikeoperations(?,?,?,?)}");
			
			
	     	cstmt.setInt(1, bike_id);
			cstmt.setString(2, model);
			cstmt.setString(3, company);
			cstmt.setDouble(4, price);
			
			//cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			
			System.out.println("Record Inserted Successfully...");
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
