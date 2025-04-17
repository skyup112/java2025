package db;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookStore extends DB_Manager{
	
	private Book books[];//객체 배열 - 기본
//	private Customer customers[];// 객체 배열 - 기본
	//ArrayList 로 객체배열을
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public BookStore(){
		books = new Book[10];
		
		for(int i=0; i<10; i++)
		{
			books[i] = new Book();
		}
	}
	
	public void getBookDB() { // 생성자
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \t\tPRICE");
			
			int index=0;
			while (rs.next()) {
//				System.out.print("" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t" + rs.getString(3));
//				System.out.println("\t\t\t" + rs.getInt(4));
				
				//books[0].bookid = rs.getInt(1);//private이라서 안됨!
				int bookid = rs.getInt(1);
				books[index].setBookid(bookid)
				;
				String bookname = rs.getString(2);
				books[index].setBookname(bookname);
				
				String publisher = rs.getString(3);
				books[index].setPublisher(publisher);
				
				int price = rs.getInt(4);
				books[index].setPrice(price);;
				
				index++;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] getBooks() {
		return books;
	}
	
	public void printBooks() {
		for(int i=0; i<books.length;i++) {
			books[i].printBook();
		}
	}
	
	public void getCustomerDB() { // DB에서 가져와서, Customer객체배열(ArrayList)에 저장
		String query = "select * from customer";
		try {
			stmt = con.createStatement(); // 2
			
			rs = stmt.executeQuery(query); // 3
			System.out.println("customer ID \tcustomer 이름 \t주소 \t전화번호");
			
//			`int index=0;
			while (rs.next()) {
//				System.out.print("" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t" + rs.getString(3));
//				System.out.println("\t" + rs.getString(4));
				int custid	= rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				
				Customer cust = new Customer();//cust객체 생성
				cust.setCustomer(custid, name, address, phone);//객체의 멤버변수에 값넣기
				customers.add(cust);//cust객체를 customer객체배열(=Arraylist)에 넣기
				
//				index++;
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void printCustomers() {
		for(int i=0; i<customers.size();i++) {
//			books[i].printBook();
			customers.get(i).printCustomer();
		}
	}
}
