package pawnApp;

public class Customer {
	String firstname;
	String lastname;
	int customerId;
	Address address;

	public Customer(String fname, String lname, int cust_id)
	{
		firstname = fname;
		lastname = lname;
		customerId = cust_id;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public int getcustomerId()
	{
		return customerId;
	}
	
}


