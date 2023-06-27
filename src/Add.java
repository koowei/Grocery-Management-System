import java.util.*;
import java.time.format.DateTimeFormatter;

public class Add 
{
	public void addMain(ArrayList<Product> products)
	{
		 String id;
		 String name;
		 String date;
		 int day;
	     int month;
	     int year;
		 double price;
		 int quantity;
		 String brand;
		 int count;
		 boolean isRepeat = false;
		 Admin ad = new Admin(); //create object for admin class
	     Scanner input = new Scanner(System.in);
	     
	     System.out.print("Enter product ID : ");
	     id = (input.nextLine()).toUpperCase();
         
         for(Product p : products)
         {
        	 if(id.equals(p.getId()))
	        		 isRepeat = true;	         
         }
         
         if(isRepeat)
         {
        	 System.out.println("Product ID is repeated. Try again.");
			 System.out.println();
			 return;
         }
	         
         System.out.print("Enter product name : ");
         name = (input.nextLine()).toUpperCase();
         
         for(Product p : products)
         {
        	 if(name.equals(p.getName()))
        		 	isRepeat = true;
         }
         
         if(isRepeat)
         {
        	 System.out.println("Product name is repeated. Try again.");
        	 System.out.println();
        	 return;
         }
	    
         try
 		 {
        	 System.out.print("Enter purchased date (DD/MM/YYYY) : ");
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
         
         try 
         {
        	 do
        	 {
        		 System.out.print("Enter price : ");
                 price = input.nextDouble();
                 
                 if(price < 0)
                	 System.out.println("Invalid input. Enter again.");
                 
        	 }while(price < 0);
         }
         
         catch(InputMismatchException e) 
		 {
        	 System.out.println("Error : Please enter a number.");
        	 System.out.println();
        	 return;
		 }
         
         try 
         {
        	 do
        	 {
        		 
        		 System.out.print("Enter product's quantity: ");
                 quantity = input.nextInt();
                 
                 if(quantity < 0)
                	 System.out.println("Invalid input. Enter again.");
                 
        	 }while(quantity < 0);
         }
         
         catch(InputMismatchException e) 
		 {
        	 System.out.println("Error : Please enter a number.");
        	 System.out.println();
        	 return;
		 }
             
         System.out.print("Enter brand name: ");
         input.nextLine();
         brand = (input.nextLine()).toUpperCase();
         products.add(new Product(id, name, date, price, quantity, brand)); //add new product object to array
         count = products.size() - 1;
         
         ad.appendProductFile(products, count); //add products' details in file 
         System.out.println("Product added successfully.");
         System.out.println();
	}
}
