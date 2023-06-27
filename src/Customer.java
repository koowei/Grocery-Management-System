public class Customer extends User
{
    public Customer(String name) 
    {
        super(name);
    }

    public String toString() 
    {
        return ("Welcome to Grocery Management System! " + super.name);
    }

}

