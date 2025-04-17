package db_Ex;

import java.sql.SQLException;



public class BookStore extends DB_manager {
	private Book books[];
//	private Customer customers[];
	
	public BookStore(){
		books = new Book[10];
		
		for(int i=0; i<10; i++)
		{
			books[i] = new Book();
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
	public void getCustomerList() { // 생성자
		String query = "select * from customer";
		try {
			stmt = con.createStatement(); // 2
			
			rs = stmt.executeQuery(query); // 3
			System.out.println("customer ID \tcustomer 이름 \t주소 \t전화번호");
			while (rs.next()) {
				System.out.print("" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


