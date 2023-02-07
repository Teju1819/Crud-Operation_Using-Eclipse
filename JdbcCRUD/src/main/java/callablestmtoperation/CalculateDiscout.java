package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculateDiscout {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bill Amount");
		int billamt=sc.nextInt();
		System.out.println("Enter Customer Type");
		String ctype=sc.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			cstmt=con.prepareCall("{?=call discount(?,?)}");
			
			
			cstmt.setInt(2, billamt);
			cstmt.setString(3, ctype);
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
		System.out.println("Discounted Amount iS: "+cstmt.getDouble(1));
		
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}

	}

}
