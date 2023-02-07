package productoperations;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		ProductSimulator p1=new ProductSimulator();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the choice \n1.Add Product \n2.Delete Product \n3. Display Product");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("Enter Product Id");
			int id=sc.nextInt();
			System.out.println("Enter Product Name");
			String name=sc.next();
			System.out.println("Enter Product Price");
			double price=sc.nextDouble();
			
			p1.addProduct(id, name, price);
			
			
			}
		else if(choice==2)
		{
			System.out.println("Enter Product Id");
			int id=sc.nextInt();
			p1.deleteProduct(id);
		}
		
		else if(choice==3)
		{
			p1.displayProduct();
		}

	}

}
