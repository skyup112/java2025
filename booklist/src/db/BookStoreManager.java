package db;

import java.util.ArrayList;

public class BookStoreManager 
{
	void run() {
//		new BookStore().getBookList();
//		new BookStore().getCustomerList();
		
		BookStore bs1 = new BookStore();
		bs1.getConn();
		bs1.getBookDB();

		//방법1: 서점에서 책들을 가져와서, 여기서 출력 
		Book[] books = bs1.getBooks();//서점(BookStore)은 책들을 꺼내는 기능(메소드)을 제공
		for(int i=0;i<books.length;i++) {
			books[i].printBook();//Book은 하나를 출력하는 기능(메소드) 제공
		}
		
		System.out.println("--------------------");
		
		//방법2: 서점에서 전체책을 출력하는 기능(메소드)을 제공
		bs1.printBooks();
		
		System.out.println("------Customer 출력------");
		
		bs1.getConn();
		bs1.getCustomerDB();
		
		//방법1: 서점에서 고객리스트를 가져와서, 여기서 출력 
		ArrayList<Customer> customers = bs1.getCustomers();//서점(BookStore)은 고객리스트를 꺼내는 기능(메소드)을 제공
		for(int i=0;i<customers.size();i++) {
//			books[i].printBook();//Book은 하나를 출력하는 기능(메소드) 제공
			customers.get(i).printCustomer();//Customer는 1개를 출력하는 기능(메소드)를 제공
		}
		
		System.out.println("--------------------");
		
		//방법2: 서점에서 전체 고객을 출력하는 기능(메소드)을 제공
		bs1.printCustomers();
	}
}




