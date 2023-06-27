import java.util.*;

public class Search 
{
	public int searchMain(ArrayList<Product> products)
	{
		int choice;
		String id;
		String name;
		boolean found = false;
		int count = -1;
		Scanner input = new Scanner(System.in);
		View v = new View();
		
		System.out.println();
		System.out.println("1. Search by product ID");
		System.out.println("2. Search by product name");
		System.out.print("Enter your choice : ");
		
		try
		{
			choice = input.nextInt(); //let user to choose search product by ID or name
			input.nextLine();
			
			if(choice == 1)
			{
				System.out.print("Enter product ID : ");
				id = input.nextLine();
				
				for(int i = 0 ; i < products.size() ; i++)
				{
					if(id.toUpperCase().equals(products.get(i).getId()))
					{
						found = true;
						System.out.println("Product is found.");
						System.out.println();
						v.displayProductDetail(products, i);
						return i;
					}
				}
			}
			
			else if(choice == 2)
			{
				System.out.print("Enter product name : ");
				name = input.nextLine();
				
				for(int i = 0 ; i < products.size() ; i++)
				{
					if(name.toUpperCase().equals(products.get(i).getName()))
					{
						found = true;
						System.out.println("Product is found.");
						System.out.println();
						v.displayProductDetail(products, i);
						return i;
					}
				}
			}
			
			else
			{
				System.out.println("Invalid input. Try again.");
				System.out.println();
				return count;
			}
		}
		
		catch(InputMismatchException e) 
		{
			System.out.println("Invalid input. Try again.");
			System.out.println();
			return count;
		}
		
		if(!found)
		{
			System.out.println("Product is not found. Try again.");
			System.out.println();
		}
		
		return count; //return -1 if product is not found
		
	}
}
