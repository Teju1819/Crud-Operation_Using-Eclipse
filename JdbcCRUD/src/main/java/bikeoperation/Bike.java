package bikeoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bike 
{

static Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
 static String model;
  static String company;
  static double price;
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addBike(String model,String company,double price)
	{
		String add="insert into bike_info (model,company,price) values(?,?,?)";
		
		try {
			pstmt=con.prepareStatement(add);
			
			pstmt.setString(1, model);
			pstmt.setString(2, company);
			pstmt.setDouble(3, price);
			
			int count=pstmt.executeUpdate();
			System.out.println(count+" Bike Added");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void getBikeByModel(String model)
	{
		String query="select * from bike_info where model='"+model+"'";
		
		try {
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			System.out.println("BIKE ID\t\tMODEL\t\tCOMPANY\t\tPRICE");
			System.out.println("====================================================");
			
			while(rs.next())
			{
				
				System.out.print(rs.getInt(1));
				System.out.print("\t\t"+rs.getString(2));
				System.out.print("\t\t"+rs.getString(3));
				System.out.print("\t\t"+rs.getDouble(4));
				System.out.println();
				
							} 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void getBikeByCompany(String company)
	{
		String query1="select model from bike_info where company='"+company+"'";
	try {
		pstmt=con.prepareStatement(query1);
		rs=pstmt.executeQuery();
		System.out.println("MODEL");
		System.out.println("=====================");
		while(rs.next())
		{
			
			String model=rs.getString(1);
			
			System.out.println(model);
		} 
	} 
	catch (SQLException e) 
	{
		
		e.printStackTrace();
	}
	}
		public void getAllBike()
		{
			
			String query="select * from bike_info";
			try {
				pstmt=con.prepareStatement(query);
				rs=pstmt.executeQuery();
				System.out.println("ID\t\tMODEL\t\tCOMPANY\t\tPRICE");
				System.out.println("====================================================");
				
				while(rs.next())
				{
					int id=rs.getInt(1);
					String model=rs.getString(2);
					String company=rs.getString(3);
					double price=rs.getDouble(4);
					System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+price);
				} 
				
			}
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
			
		}
	}
	

