package callablestmtoperation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Radius");
		double radius=sc.nextDouble();
		
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
            cstmt=con.prepareCall("{?=call areaofcircle(?)}");
			
			cstmt.setDouble(2, radius);
		
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			
			System.out.println("AREA OF CIRCLE IS "+cstmt.getDouble(1));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
