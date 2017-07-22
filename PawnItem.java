package pawnApp;

public class PawnItem {

	String type;
	String name;
	float weight;
	int karat;
	double valueOfItem;
	int id;
	private PawnItem next;
	public PawnItem(String name,String type, float weight, int karat, int id)
	{
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.karat = karat;
		this.id = id;
		this.next = null;
		
	}
	public double computeValue()
	{
		double val;
		if (type.equals ("gold"))
		{
			switch (karat)
			{
			case 24: valueOfItem = (weight * 2176);
			System.out.println(valueOfItem);
			break;
			case 22: valueOfItem = (weight * 1996);
			break;
			case 18: valueOfItem = (weight * 1664);
			break;
			case 14: valueOfItem = (weight * 1280);
			break;
			case 10: valueOfItem = (weight * 1000);
			break;
			default: System.out.println("invalid entry");
			}	
			//System.out.println("The value of the item is "+value);
			this.valueOfItem = valueOfItem;
			val =  amountGivenToCustomer();
		}
		else if (type.equals("silver"))
		{
			switch(karat)
			{
			case 24: valueOfItem = (weight * 2000);
			break;
     		case 22: valueOfItem = (weight * 1800);
			break;
			case 18: valueOfItem = (weight * 1600);
			break;
			case 14: valueOfItem = (weight * 1400);
			break;
			case 10: valueOfItem = (weight * 1200);
			break;
			default: System.out.println("invalid entry");
			}
			//System.out.println("The value of the item is "+value);
			this.valueOfItem = valueOfItem;
			val = amountGivenToCustomer();
			
		}
		else
		{
			switch(karat)
			{
			case 24: valueOfItem = (weight * 4000);
			break;
			case 22: valueOfItem = (weight * 3800);
			break;
			case 18: valueOfItem = (weight * 3600);
			break;
			case 14: valueOfItem = (weight * 3400);
			break;
			case 10: valueOfItem = (weight * 3200);
			break;
			default: System.out.println("invalid entry");
			}
			//System.out.println("The value of the item is "+value);
			this.valueOfItem = valueOfItem;
			val  = amountGivenToCustomer();
			
		}
		return val;
		
	}
	public double amountGivenToCustomer()
	{
		double amount = (valueOfItem * 0.75);
		//System.out.println("The amount Given to customer for that item is "+amount);
		return amount;
	}
	/*public double amountToBeReturned(double amt , int noOfDays)
	{
		double interest_rate_per_day = (0.1/365);
		double  interest_per_day = (interest_rate_per_day * amt);
		double interest = (interest_per_day * noOfDays);
		double amountToBeReturned = (amt + interest);
		return amountToBeReturned;
	}*/
	public String getName()
	{
		return name;
	}
	public float getWeight()
	{
		return weight;
	}
	public int getKarat()
	{
		return karat;
	}
	public PawnItem getNext()
	{
		return next;
	}
	public void setNext(PawnItem nextItem)
	{
		this.next = nextItem;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return (this.id == ((PawnItem)obj).id);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public String toString() {
		return "PawnItem [type=" + type + ", name=" + name + ",  weight=" + weight + ", karat="
				+ karat + ", valueOfItem=" + valueOfItem + ", id=" + id + "]";
}
}
