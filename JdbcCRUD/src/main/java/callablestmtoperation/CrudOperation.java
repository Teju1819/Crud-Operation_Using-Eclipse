package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudOperation {

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
		System.out.println("Enter User Id To Delete");
		int u_id=sc.nextInt();
		System.out.println("Enter Product Id to Update");
		int pid=sc.nextInt();
		System.out.println("Enter New Price");
		Double pprice=sc.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			
			cstmt=con.prepareCall("{call crudOperationsProcedure(?,?,?,?,?,?,?)}");
			
			cstmt.setInt(1, bike_id);
			cstmt.setString(2, model);
			cstmt.setString(3, company);
			cstmt.setDouble(4, price);
			cstmt.setInt(5, u_id);
			cstmt.setInt(6, pid);
			cstmt.setDouble(7, pprice);
                  cstmt.execute();
			
			System.out.println("Record Inserted ,Deleted And Updated Successfully...");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}
