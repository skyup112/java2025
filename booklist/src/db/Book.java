package db;

public class Book
{
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public void printBook()
	{
		System.out.print(" "+bookid);
		System.out.print(" "+bookname);
		System.out.print(" "+publisher);
		System.out.print(" "+price);
		System.out.println();
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
