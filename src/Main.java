import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String [] args) 
	{
		int choice;
		boolean isStaff = true;
		Admin ad = new Admin(); //create object for admin class
		Add a = new Add(); //create object for add class
		Delete d = new Delete(); //create object for delete class
		Search s = new Search(); //create object for search class
		Edit e = new Edit(); //create object for edit class
		View v = new View(); //create object for view class
		ArrayList<Product> products; //create an array list for products
		ArrayList<Staff> staffs; //create an array list for staffs
		
		isStaff = ad.displayLoginScreen(); //check the user is staff or customer
		products = ad.readProductsFromFile(); //read products' details from product file into array
		staffs = ad.readStaffFromFile(); //read staffs' details from staff file into array
		
		if(isStaff == true)
		{
			do 
			{
				choice = ad.displayStaffMenu();

				switch(choice)
				{
					case 1: //case 1 is add products' details
						a.addMain(products);
						break;
						
					case 2: //case 2 is delete products' details
						d.deleteMain(products);
						break;
						
					case 3: //case 3 is search product by id or name
						s.searchMain(products);
						break;
						 
					case 4: //case 4 is edit products' details
						e.editMain(products);
						break;
						
					case 5: //case 5 is display product list
						v.displayProductList(products);
						break;
						
					case 6: //case 6 is display staff list
						v.displayStaffList(staffs);
						break;
						
					case 7: //case 7 is change staff's password
						ad.changePassword(staffs);
						break;
						
					case 8: //case 8 is exit to the login page
						main(args);
						break;
						
					default: //display error message if user enter value that is not from 1 to 8
						System.out.println("Invalid input. Enter again.");
						System.out.println();
				}
				
			} while(choice != 8);
		}
		
		else
		{
			do 
			{
				choice = ad.displayCustomerMenu();

				switch(choice)
				{
					case 1: //case 1 is display product list
						v.displayProductList(products);
						break;
						
					case 2: //case 2 is search product by id or name
						s.searchMain(products);
						break;
					
					case 3: //case 3 is exit to the login page
						main(args);
						break;
						
					default: //display error message if user enter value that is not from 1 to 3
						System.out.println("Invalid input. Enter again.");
						System.out.println();
				}
				
			} while(choice != 3);
		}
	}
}
	
	