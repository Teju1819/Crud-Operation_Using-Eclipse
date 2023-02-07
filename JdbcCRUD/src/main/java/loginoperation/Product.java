package loginoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product 
{
	static Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	Scanner sc1=new Scanner(System.in);
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void loginDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Name");
		String user=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		String query="select user,password from login_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			boolean status=false;
			while(rs.next())
			{
				String dbuser=rs.getString(1);
				String dbpassword=rs.getString(2);
				if(dbuser.equals(user) && dbpassword.equals(password))
				{
					System.out.println("LOGIN SUCCESSFUL...");
					System.out.println("=================================================");
					System.out.println("Enter the choice \n1.Display Product \n2.Add Product");
					int choice=sc.nextInt();
					if(choice==1)
					{
						displayProduct();
					}
					else if(choice==2)
					{
						addProduct();
					}
					
					status=true;
				}
			}
			if(status=false)
			{
				System.out.println("INVALID LOGIN DETAILS.....");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void displayProduct()
	{
		String query="Select * from product_info";
		try {
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
			
			e.printStackTrace();
		}
	}
	
	public void addProduct()
	{
		
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();
		
		System.out.println("Enter Product Name");
		String name=sc1.next();
		
		System.out.println("Enter Product Price");
	    double price=sc1.nextDouble();	
	    
	    String query="insert into product_info values("+id+",'"+name+"',"+price+")";
	    try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+" Product inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void signUp()
	{
		System.out.println("Enter User Id");
		int id=sc1.nextInt();
		
		System.out.println("Enter User Name");
		String user=sc1.next();
		
		System.out.println("Enter User Password");
	    String password=sc1.next();	
	    
	    String query="insert into login_info values("+id+",'"+user+"',"+password+")";
	    try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+" Product inserted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}

}
