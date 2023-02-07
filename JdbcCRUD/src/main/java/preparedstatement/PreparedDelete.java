package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDelete {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query1="delete from product_info where product_id=?";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			pstmt=con.prepareStatement(query1);
			
			pstmt.setInt(1, 6);
			int count1=pstmt.executeUpdate();	
			
			pstmt.setInt(1, 7);
			int count2=pstmt.executeUpdate();	
			
			pstmt.setInt(1, 3);
			int count3=pstmt.executeUpdate();	
			
			System.out.println(count1+count2+count3+" Record Deleted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
