package producttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp1 {

	public static void main(String[] args) 
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Lower Price");
		double lowprice=sc.nextDouble();
		System.out.println("Enter Higher Price");
		double highprice=sc.nextDouble();
		
	    Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String query="select * from product_info where product_price Between"+lowprice+ "AND" +highprice;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("ID\t\tNAME\t\tPRICE");
			System.out.println("====================================================");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
