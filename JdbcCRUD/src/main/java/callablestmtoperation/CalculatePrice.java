package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculatePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Quantity");
		int quantity=sc.nextInt();
		System.out.println("Enter Price");
		double price=sc.nextDouble();
		
		
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			cstmt=con.prepareCall("{?=call billCalculator(?,?)}");
			
			cstmt.setDouble(2, price);
			cstmt.setInt(3, quantity);
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			
			System.out.println("TOTAL PRICE IS "+cstmt.getDouble(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
