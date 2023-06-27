public class Product 
{
	private String id;
	private String name;
	private String date;
	private double price;
	private int quantity;
	private String brand;
	
	public Product(String id, String name, String date, double price, int quantity, String brand)
	{
		this.id = id;
		this.name = name;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
}
