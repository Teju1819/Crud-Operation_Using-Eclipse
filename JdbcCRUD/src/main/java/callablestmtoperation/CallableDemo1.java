package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableDemo1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No1");
		int no1=sc.nextInt();
		System.out.println("Enter No2");
		int no2=sc.nextInt();
		
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			//Create platform using callable statement
			cstmt=con.prepareCall("{?=call addNumbers(?,?)}");
			////set input to second and third placeholder
			cstmt.setInt(2, no1);
			cstmt.setInt(3, no2);
			//store output into first placeholder
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			//get output from first placeholder
			System.out.println("ADDITION IS "+cstmt.getInt(1));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
