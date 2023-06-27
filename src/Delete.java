import java.io.*;
import java.util.*;

public class Delete 
{
	public void deleteMain(ArrayList<Product> products)
	{
		Admin ad = new Admin(); //create object for admin class
		Search s = new Search(); //create object for search class
		int delete_select;
		int count;
	    Scanner input = new Scanner(System.in);
		
		System.out.println("Which product's information you want to delete ?");
		count = s.searchMain(products);
		
		if(count != -1)
		{
			products.remove(count); //remove selected product object from array
			ad.updateProductFile(products); //update products' details in file 
			System.out.println("Product is deleted succesfully.");
			System.out.println();
		}
	}
}
