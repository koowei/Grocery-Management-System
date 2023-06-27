public class Staff extends User
{
	private String staff_id;
	
    public Staff(String staff_id, int password) 
    {
        super(password);
        this.staff_id = staff_id;
    }
    
    public String getId()
    {
    	return staff_id;
    }
}
