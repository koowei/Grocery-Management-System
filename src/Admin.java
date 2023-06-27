import java.util.*;
import java.io.*;

public class Admin 
{
	//display the main menu for login 
	public boolean displayLoginScreen()
	{
		int choice;
		boolean isStaff = true;
        Scanner input  = new Scanner(System.in);
        System.out.print("****************************************************\n");
        System.out.print("                                                    \n");
        System.out.print("         Grocery Store Management System            \n");
        System.out.print("                                                    \n");
        System.out.print("****************************************************\n");
        System.out.println();
        System.out.print("             Do you want to log in as : \n");
        System.out.print("                   1 = Staff \n");
        System.out.print("                   2 = Customer\n");
        System.out.print("                   3 = Exit\n");
        System.out.println();
        
        try
        {
        	do 
    		{
        		System.out.print("Enter your choice : "); //let user choose to login as staff or customer
            	choice = input.nextInt();
                System.out.println(); 
                 
                switch(choice)
    			{
    				case 1:
    				{
    					isStaff = staffLogin();
    					
    					if(isStaff)
    						return isStaff;
    					else
    						return displayLoginScreen();
    				}
    				
    				case 2:
    				{
    					customerLogin();
    					return isStaff = false;
    				}
    				
    				case 3:
    					System.exit(0);
    					break;
    					
    				default:
    					System.out.println("Invalid input. Enter again.");
    					System.out.println();
    			}
    			
    		} while(choice != 3);
        }
            
        catch(InputMismatchException e)
        {
        	System.out.println("Invalid input. Enter again.");
			System.out.println();
			return displayLoginScreen();
        }
        
        return isStaff;
	}
	
	//display the customer main menu 
	public int displayCustomerMenu() 
	{
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("|------------------------------------|");
		System.out.println("|           User : Customer          |");
	    System.out.println("|------------------------------------|");
	    System.out.println("| 1. View product                    |");
	    System.out.println("| 2. Search product                  |");
	    System.out.println("| 3. Logout                          |");
	    System.out.println("|                                    |");
	    System.out.println("| Enter numbers to choose option.    |");
	    System.out.println("|------------------------------------|");
	    
	    do 
	    {
			try 
			{
				System.out.print("==> "); //let customer to select function
				choice = input.nextInt();
			}
			
			catch(InputMismatchException e) 
			{
				System.out.println("Invalid input. Enter again.");
				System.out.println();
				return displayCustomerMenu();
			}
			
			if(choice < 1 || choice > 3)
			{
				System.out.println("Invalid input. Enter again.");
			}

	    }while(choice < 1 || choice > 3);
			
	    return choice;
	}
	
	//display the staff main menu 
	public int displayStaffMenu() 
	{
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("|------------------------------------|");
	    System.out.println("|            User : Staff            |");
	    System.out.println("|------------------------------------|");
	    System.out.println("| 1. Add product                     |");
	    System.out.println("| 2. Delete product                  |");
	    System.out.println("| 3. Search product                  |");
	    System.out.println("| 4. Edit product                    |");
	    System.out.println("| 5. View product                    |");
	    System.out.println("| 6. View staff                      |");
	    System.out.println("| 7. Change password                 |");
	    System.out.println("| 8. Logout                          |");
	    System.out.println("|                                    |");
	    System.out.println("| Enter numbers to choose option.    |");
	    System.out.println("|------------------------------------|");

	    do 
	    {
			try 
			{
				System.out.print("==> "); //let staff to select function
				choice = input.nextInt();
			}
			
			catch(InputMismatchException e) 
			{
				System.out.println("Invalid input. Enter again.");
				System.out.println();
				return displayStaffMenu();
			}
			
			if(choice < 1 || choice > 8)
			{
				System.out.println("Invalid input. Enter again.");
			}
			
	    }while(choice < 1 || choice > 8);
			
	    return choice;
	}
	
	//read products' details from file into array 
	public ArrayList<Product> readProductsFromFile()
	{
		ArrayList<Product> products = new ArrayList<>(); //create array for products
		
		File product_list = new File("Product.txt");
		Scanner products_reader;
		try 
		{
			products_reader = new Scanner(product_list);
			
			while(products_reader.hasNext())
			{
				String id = products_reader.nextLine();
				String name = products_reader.nextLine();
				String date = products_reader.nextLine();
				double price = products_reader.nextDouble();
				int quantity = products_reader.nextInt();
				products_reader.nextLine();
				String brand = products_reader.nextLine();
				
				products.add(new Product(id, name, date, price, quantity, brand)); //read product details from file into products array
			}
			
			products_reader.close();
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("Error : Product file is not found.");
			System.out.println();
		}
		
		return products; //return products array
	}
	
	//update products' details in file 
	public void updateProductFile(ArrayList<Product> products)
	{
		try 
		{
			File product_list = new File("Product.txt");
			PrintWriter writer = new PrintWriter(product_list);
			for(int i = 0 ; i < products.size() ; i++)
			{
				writer.println(products.get(i).getId());
				writer.println(products.get(i).getName());
				writer.println(products.get(i).getDate());
				writer.println(products.get(i).getPrice());
				writer.println(products.get(i).getQuantity());
				writer.println(products.get(i).getBrand());
			}
				
			writer.close();
		} 
		
		catch (IOException e) 
		{
			System.out.println("Error : Product file is not found.");
			System.out.println();
		}
	}
	
	//add products' details in file 
	public void appendProductFile(ArrayList<Product> products, int count)
	{
		 try
         {
        	 File product_list = new File("Product.txt");
        	 FileWriter writer = new FileWriter(product_list, true);
        	 
        	 writer.append("\n" + products.get(count).getId());
        	 writer.append("\n" + products.get(count).getName());
        	 writer.append("\n" + products.get(count).getDate());
        	 writer.append("\n" + products.get(count).getPrice());
        	 writer.append("\n" + products.get(count).getQuantity());
        	 writer.append("\n" + products.get(count).getBrand());
        	 writer.close();
         }
         
         catch (IOException e) 
         {
			System.out.println("Error : Product file is not found.");
			System.out.println();
         }
	}
	
	//read staffs' details from file into array 
	public ArrayList<Staff> readStaffFromFile()
	{
		ArrayList<Staff> staffs = new ArrayList<>();
		
		File staff_list = new File("Staff.txt");
		Scanner products_reader;
		try 
		{
			products_reader = new Scanner(staff_list);
			
			while(products_reader.hasNext())
			{
				String id = products_reader.next();
				int password = products_reader.nextInt();
				
				staffs.add(new Staff(id, password));
			}
			
			products_reader.close();
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("Error : Staff file is not found.");
			System.out.println();
		}
		
		return staffs; //return staffs array
	}
	
	//update staffs' details in file 
	public void updateStaffFile(ArrayList<Staff> staffs)
	{
		try 
		{
			File staff_list = new File("Staff.txt");
			PrintWriter writer = new PrintWriter(staff_list);
			for(int i = 0 ; i < staffs.size() ; i++)
			{
				writer.println(staffs.get(i).getId());
				writer.println(staffs.get(i).getPassword());
			}
				
			writer.close();
		} 
		
		catch (IOException e) 
		{
			System.out.println("Error : Staff file is not found.");
			System.out.println();
		}
	}
	
	//login page for staff
	public boolean staffLogin()
	{
		String id;
		int password;
		int staffNo;
		boolean isStaff = true;
		ArrayList<Staff> staffs = readStaffFromFile(); 
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter staff ID : ");
		id = input.nextLine();
		
		for(int i = 0 ; i < staffs.size() ; i++)
		{
			if(id.equals(staffs.get(i).getId()))
			{
				System.out.println("Staff is found.");
				System.out.print("Enter password (in number) : ");
				password = input.nextInt();
				
				if(password == staffs.get(i).getPassword())
				{
					System.out.println("Login Successfully."); 
					System.out.println();
					return isStaff; //return isStaff = true if user enter correct staff ID and password
				}
				else
				{
					System.out.println("Incorrect password. Try again.");
					System.out.println();
					return isStaff = false;
				}
			}
			
		}
		
		System.out.println("Staff is not found. Try again.");
		System.out.println();
		return isStaff = false; //return isStaff = false if user enter wrong password or staff ID is not found
	}
	
	//login page for staff
	public void customerLogin()
	{
		String name;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter name : ");
		name = input.nextLine();
		System.out.println();
		
		Customer c = new Customer(name);
		System.out.println(c.toString());
	}
	
	//let staff to change staff's password
	public void changePassword(ArrayList<Staff> staffs)
	{
		String id;
		int password;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter staff ID : ");
		id = input.nextLine();
		
		for(int i = 0 ; i < staffs.size() ; i++)
		{
			if(id.equals(staffs.get(i).getId()))
			{
				 try 
		         {
					 System.out.print("Enter new password (in number) : ");
	 				 password = input.nextInt();
		         }
		         
		         catch(InputMismatchException e) 
				 {
		        	 System.out.println("Error : Please enter number.");
		        	 System.out.println();
		        	 return;
				 }
				
				staffs.set(i, new Staff(id, password));
				updateStaffFile(staffs);
				
				System.out.println("Password changed successfully.");
				System.out.println();
				return;
			}
		}
		
		System.out.println("Staff is not found. Try again.");
		System.out.println();
	}
}
	
