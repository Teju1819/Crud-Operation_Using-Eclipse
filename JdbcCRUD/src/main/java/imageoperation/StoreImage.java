package imageoperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		String query="insert into course_info(c_name,c_image) values(?,?)";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,"JAVA");
			fin=new FileInputStream("D:\\Tejashri\\1EJA7\\Data\\java.png");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			pstmt.setString(1,"SQL");
			fin=new FileInputStream("D:\\Tejashri\\1EJA7\\Data\\sql.jpg");
			pstmt.setBinaryStream(2, fin);
			pstmt.executeUpdate();
			
			
			System.out.println("Info Inserted...");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
