package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Customer {
	private int custid;
	private String name;
	private String address;
	private String phone;

	public void printCustomer() {
		System.out.print(" " + custid);
		System.out.print(" " + name);
		System.out.print(" " + address);
		System.out.print(" " + phone);
		System.out.println();

	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

class Customerlist {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private Customer cust[];

	public Customerlist() {
		cust = new Customer[5];
		
		for(int i=0; i<5; i++)
		{
			cust[i] = new Customer();
		}
	}
	public Customer[] getcust() {
		return cust;
	}

	public void printCust() {
		for (int i = 0; i < cust.length; i++) {
			cust[i].printCustomer();
		}

	}

	public void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "c##madang"; // c##추가
		String pwd = "c##madang"; // c##추가

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getCust() { // 생성자
		String query = "SELECT * FROM CUSTOMER";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("CUSTID \tNAME \tADDRESS\tPHONE");

			int index = 0;
			while (rs.next()) {
				int Custid = rs.getInt(1);
				cust[index].setCustid(Custid);
				String Name = rs.getString(2);
				cust[index].setName(Name);
				String Address = rs.getString(3);
				cust[index].setAddress(Address);
				String Phone = rs.getString(4);
				cust[index].setPhone(Phone);

				index++;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public class DB_main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customerlist a = new Customerlist();
		a.getConn();
		a.getCust();
		a.printCust();

	}

}
