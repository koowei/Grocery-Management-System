import java.util.ArrayList;

public class View 
{
	//display all products' details
	public void displayProductList(ArrayList<Product> products)
	{
		System.out.println();
		
		for(int i = 0 ; i < products.size() ; i++)
		{
			System.out.print((i+1)+ ". \nProduct ID: " +products.get(i).getId());
			System.out.print("\nProduct name: " +products.get(i).getName());
			System.out.print("\nPurchased date: " +products.get(i).getDate());
			System.out.print("\nPrice: RM" +products.get(i).getPrice());
			System.out.print("\nQuantity: " +products.get(i).getQuantity());
			System.out.println("\nBrand: " +products.get(i).getBrand());
			System.out.println();
		}
	}
	
	//display all products' ID and name
	public void displayProductId(ArrayList<Product> products)
	{
		for(int i = 0 ; i < products.size() ; i++)
		{
			System.out.print((i+1)+ ". \nProduct ID: " +products.get(i).getId());
			System.out.print("\nProduct name: " +products.get(i).getName());
			System.out.println();
			System.out.println();
		}
	}
	
	//display specific products' details
	public void displayProductDetail(ArrayList<Product> products, int count)
	{
		System.out.print((count + 1)+ ". \nProduct ID: " +products.get(count).getId());
		System.out.print("\nProduct name: " +products.get(count).getName());
		System.out.print("\nPurchased date: " +products.get(count).getDate());
		System.out.print("\nPrice: RM" +products.get(count).getPrice());
		System.out.print("\nQuantity: " +products.get(count).getQuantity());
		System.out.println("\nBrand: " +products.get(count).getBrand());
		System.out.println();
	}
	
	//display all staffs' ID and password
	public void displayStaffList(ArrayList<Staff> staffs)
	{
		for(int i = 0 ; i < staffs.size() ; i++)
		{
			System.out.print((i+1)+ ". \nStaff ID: " +staffs.get(i).getId());
			System.out.println("\nPassword: " +staffs.get(i).getPassword());
			System.out.println();
		}
	}
}
