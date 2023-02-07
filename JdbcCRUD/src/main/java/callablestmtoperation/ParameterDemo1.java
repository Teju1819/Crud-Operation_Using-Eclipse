package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ParameterDemo1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bike Company");
		String company=sc.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			cstmt=con.prepareCall("{call parameterdemo(?,?)}");
			
			cstmt.setString(1, company);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			System.out.println("Total No Of Models Are: "+cstmt.getInt(2));
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
