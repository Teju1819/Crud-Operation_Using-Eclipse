package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedDemo1 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query1="insert into product_info values(?,?,?)";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			pstmt=con.prepareStatement(query1);
			
			pstmt.setInt(1, 6);
			pstmt.setString(2,"TV");
			pstmt.setDouble(3,15000.25);
			int count1=pstmt.executeUpdate();	
			
			pstmt.setInt(1, 7);
			pstmt.setString(2,"Projector");
			pstmt.setDouble(3,25000.25);
			
			int count2=pstmt.executeUpdate();
			
			System.out.println(count1+count2+" Record Inserted");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
