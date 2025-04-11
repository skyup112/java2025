package customerDB;

import java.util.ArrayList;

public class Cust_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerManager bs1 = new CustomerManager();
		bs1.getConn();
		bs1.getCustDB();
		ArrayList<Customer> customer = bs1.getCustmomers();
		for (int i = 0; i < customer.size(); i++) {
			customer.get(i).printCustomer();
		}
		System.out.println("--------------------");
		bs1.printCustmomers();


	}

}
