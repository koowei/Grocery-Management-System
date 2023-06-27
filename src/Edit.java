import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class Edit 
{
	public void editMain(ArrayList<Product> products)
	{
		String name;
		String id;
		String date;
		int day;
		int month;
		int year;
		double price;
		int quantity;
		String brand;
		Admin ad = new Admin(); //create object for admin class
		Search s = new Search(); //create object for search class
		int choice, count;
	    Scanner input = new Scanner(System.in);
	    
		System.out.println("Which product's information you want to edit ?");
		count = s.searchMain(products);
		
		if(count == -1)
		{
			return;
		}
			
		else
		{
			System.out.println();
			System.out.println("Which information you want to edit ?");
			System.out.println("1. Purchased date");
			System.out.println("2. Price");
			System.out.println("3. Quantity");
			System.out.println("4. Brand");
			System.out.print("Enter your choice : ");
			
			try
			{
				choice = input.nextInt();
				input.nextLine();
				
				if(choice == 1)
				{
					id = products.get(count).getId();
					name = products.get(count).getName();
					price = products.get(count).getPrice();
					quantity = products.get(count).getQuantity();
					brand = products.get(count).getBrand();
					
					try
			 		 {
			        	 System.out.print("Enter purchased date: ");
			             date = input.nextLine();

			             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
			        	 formatter.parse(date);
			 			 day = Integer.parseInt(date.substring(0,2));
			 			 month = Integer.parseInt(date.substring(3,5));
			 			 year = Integer.parseInt(date.substring(6,10));
			 			
			 			 if(day > 31 || day < 1 || month >12 || month < 1)
			 			 {
			 				 System.out.println("Invalid date. Try again.");
			 				 System.out.println();
			 				 return;
			 			 }
			 		 }
			         
			 		 catch(Exception e)
			 		 {
			 			 System.out.println("Invalid date. Try again.");
			 			 System.out.println();
			 			 return;
			 		 }
			        
			        products.set(count, new Product(id, name, date, price, quantity, brand)); //overwrites the existing product object in array
				}
				
				else if(choice == 2)
				{
					id = products.get(count).getId();
					name = products.get(count).getName();
					date = products.get(count).getDate();
					quantity = products.get(count).getQuantity();
					brand = products.get(count).getBrand();
					
					try 
			        {
			        	 do
			        	 {
			        		 System.out.print("Enter new price : ");
			                 price = input.nextDouble();
			                 
			                 if(price < 0)
			                	 System.out.println("Invalid input. Enter again.");
			                 
			        	 } while(price < 0);
			         }
			         
			         catch(InputMismatchException e) 
					 {
			        	 System.out.println("Error : Please enter a number.");
			        	 System.out.println();
			        	 return;
					 }
					
			        products.set(count, new Product(id, name, date, price, quantity, brand));
				}
				
				else if(choice == 3)
				{
					id = products.get(count).getId();
					name = products.get(count).getName();
					date = products.get(count).getDate();
					price = products.get(count).getPrice();
					brand = products.get(count).getBrand();
					
					try 
			         {
			        	 do
			        	 {
			        		 System.out.print("Enter new quantity: ");
			                 quantity = input.nextInt();
			                 
			                 if(quantity < 0)
			                	 System.out.println("Invalid input. Enter again.");
			                 
			        	 } while(quantity < 0);
			         }
			         
			         catch(InputMismatchException e) 
					 {
			        	 System.out.println("Error : Please enter a number.");
			        	 System.out.println();
			        	 return;
					 }
			        
			        products.set(count, new Product(id, name, date, price, quantity, brand));
				}
				
				else if(choice == 4)
				{
					id = products.get(count).getId();
					name = products.get(count).getName();
					date = products.get(count).getDate();
					price = products.get(count).getPrice();
					quantity = products.get(count).getQuantity();
					
					System.out.print("Enter new brand : ");
			        brand = (input.nextLine()).toUpperCase();
			        
			        products.set(count, new Product(id, name, date, price, quantity, brand));
				}
				
				else
				{
					System.out.println("Invalid input. Try again.");
					System.out.println();
					return;
				}
			}
			
			catch(InputMismatchException e) 
			{
				System.out.println("Invalid input. Try again.");
				System.out.println();
				return;
			}
		}
		
		ad.updateProductFile(products); //update products' details in file  
		System.out.println("Product's information edited successfully.");
		System.out.println();
	}
					
}
