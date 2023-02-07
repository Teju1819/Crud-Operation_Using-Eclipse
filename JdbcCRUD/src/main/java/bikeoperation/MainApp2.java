package bikeoperation;



import java.util.Scanner;

public class MainApp2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bike b1=new Bike();
		
		
		System.out.println("Enter the choice \n1.Add Bike \n2.Get Bike By Model \n3. Get Bike By Company \n4 Display Bike Details");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("Enter bike model");
			String model=sc.next();
			
			System.out.println("Enter bike company");
			String company=sc.next();
			
			System.out.println("Enter bike price");
			double price=sc.nextDouble();
			
			b1.addBike(model, company, price);
			}
		
		else if(choice==2)
		{
			System.out.println("Enter bike model");
			String model=sc.next();
			b1.getBikeByModel(model);
		}
		
		else if(choice==3)
		{
			System.out.println("Enter bike company");
			String company=sc.next();
			b1.getBikeByCompany(company);
		}
		
		else if(choice==4)
		{
			b1.getAllBike();
		}
	}

}
