package pawnApp;

public class Pawn {
	private Customer customer;
	private int pawnId;
	private PawnItem first;

	public Pawn(Customer cust) {
		first = null;
		this.customer = cust;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getPawnId() {
		return pawnId;
	}

	public PawnItem getFirst() {
		return first;
	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else
			return false;
	}

	public void insertFirstPawnItem(PawnItem pawnItem) {
		this.first = pawnItem;
		this.first.setNext(null);
	}
	
	public void insertNewPawnItem(PawnItem pawnItem) {
		PawnItem temp = first;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(pawnItem);
	}
	public int numberOfPawnItems()
	{
		PawnItem temp = first;
		int count = 0;
		while (temp!=null)
		{
			temp = temp.getNext();
			count = count + 1;
		}
		return count;
	}

	public Pawn removePawnItem(PawnItem pawnItem) {
		PawnItem prev = null;
		PawnItem temp = first;
		while (temp.getNext() != null) {
			if (pawnItem.equals(temp)) {
				prev.setNext(temp.getNext());
				break;
			}
			else
			{
				prev = temp;
				temp = temp.getNext();
			}
		}
		//System.out.println("Inside remove Pawn Item." + "\n" + this.display());
		return this;
	}
	public double amountToBeReturned(int noOfDays)
	{
		PawnItem temp = first;
		double sum = 0.0;
		while (temp!=null)
		{
			sum = sum + temp.computeValue();
			temp = temp.getNext();
		}
		double interest_rate_per_day = (0.1/365);
		double  interest_per_day = (interest_rate_per_day * sum);
		double interest = (interest_per_day * noOfDays);
		double amountToBeReturned = (sum + interest);
		return amountToBeReturned;
	}

	public String display() {
		int count = 1;
		String s="";
		PawnItem temp = first;
		while (temp != null) {
			s=s+"The # " + count + " " + temp.toString()+"\n";
			count = count + 1;
			temp = temp.getNext();
		}
		return s;
	}

	public void insertPawnItem(int pos, PawnItem pawnItem) {
		PawnItem prev = null;
		PawnItem temp = first;
		int count = 1;
		while (temp.getNext() != null && pos != count) {
			prev = temp;
			temp = temp.getNext();
			count = count + 1;
		}
		pawnItem.setNext(temp);
		prev.setNext(pawnItem);
	}
}

