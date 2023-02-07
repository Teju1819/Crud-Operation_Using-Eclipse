package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CustomerType {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Credit Limit");
		int creditlimit=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			 cstmt=con.prepareCall("{?=call customerType(?)}");
				
				cstmt.setInt(2, creditlimit);
				
				cstmt.registerOutParameter(1, Types.VARCHAR);
				cstmt.execute();
				System.out.println("CUSTOMER TYPE IS: "+cstmt.getString(1));
				
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		

	}

}
