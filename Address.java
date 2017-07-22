package pawnApp;

public class Address {

	int door_no;
	String Street_name;
	long pin;
	String city;
	String state;
	public Address(int door_no, String Street_name , long pin , String city , String state)
	{
		this.door_no = door_no;
		this.Street_name = Street_name;
		this.pin = pin;
		this.city = city;
		this.state = state;
	}
	public int getdoor_no()
	{
		return door_no;
	}
	public String getStreet_name()
	{
		return Street_name;
	}
	public long getpin()
	{
		return pin;
	}
	public String getcity()
	{
		return city;
	}
	public String getstate()
	{
		return state;
	}
}
