package customerDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CustomerManager extends Customer {
	private ArrayList<Customer> customer = new ArrayList<Customer>();
	Connection con;
	Statement stmt;
	ResultSet rs;
	
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

	public void getCustDB() { 
		String query = "SELECT * FROM CUSTOMER";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("CUSTID \tNAME \tADDRESS\tPHONE");

			while (rs.next()) {
				int Custid = rs.getInt(1);
				String Name = rs.getString(2);
				String Address = rs.getString(3);
             	String Phone = rs.getString(4);
             	
             	Customer cust=new Customer();
             	cust.setCustomer(Custid, Name, Address, Phone);
             	customer.add(cust);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Customer> getCustmomers() {
		return customer;
	}
	
	public void printCustmomers() {
		for(int i=0; i<customer.size();i++) {
			customer.get(i). printCustomer();
		}
		
	}

}
