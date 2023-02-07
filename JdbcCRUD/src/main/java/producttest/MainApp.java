package producttest;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ProductDemo p2=new ProductDemo();
		System.out.println("Enter the choice \n1.Max Price \n2.Min Price");
		int choice=sc.nextInt();
		if(choice==1)
		{
			p2.maxPrice();
		}
		
		else if(choice==2)
		{
			p2.minPrice();
		}
		
	}

}
