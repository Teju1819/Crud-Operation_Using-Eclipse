package loginoperation;

import java.util.Scanner;

public class LoginApplication1 {

	public static void main(String[] args) {
		

		Product p1=new Product();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the choice \n1.Login \n2.SingUp");
		int choice=sc.nextInt();
		if(choice==1)
		{
			p1.loginDetails();
		}
		else if(choice==2)
		{
			p1.signUp();
		}
	}

}
