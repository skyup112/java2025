package db_Ex;

public class DB_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore bs1 = new BookStore();
		bs1.getConn();
		bs1.getBookDB();
		
		Book[] books = bs1.getBooks();
		
		for(int i=0;i<books.length;i++) {
			books[i].printBook();
		}
		
		System.out.println("--------------------");
		
		bs1.printBooks();


	}

}
