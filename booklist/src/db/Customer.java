package db;

public class Customer 
{
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	void setCustomer(int custid, String name, 
			         String address, String phone) {
		this.custid = custid;
		this.name = name;
		this.address =address;
		this.phone = phone;
	}
	
	public void printCustomer()
	{
		System.out.print(" "+custid);
		System.out.print(" "+name);
		System.out.print(" "+address);
		System.out.print(" "+phone);
		System.out.println();
	}
}
