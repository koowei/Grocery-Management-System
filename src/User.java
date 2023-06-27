public class User 
{
	protected String name;
	protected int password;
	
	public User(String name)
	{
		this.name = name;
	}
	
	public User(int password)
	{
		this.password = password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPassword()
	{
		return password;
	}
}
