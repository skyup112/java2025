package booklist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class Booklist {
	Connection con;
	Statement stmt;
	ResultSet rs;

	public Booklist() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "c##madang";
		String pwd = "c##madang";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("데이터베이스 연결준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터 베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqlRun() {
		String query = "SELECT * FROM BOOK";
		try {
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			System.out.println("BOOK No\tBOOK NAME\t\tPUBLISHER \tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void sqlRun2() {
			String query = "SELECT * FROM CUSTOMER";
			try {
				 stmt = con.createStatement();
				 rs = stmt.executeQuery(query);
				System.out.println("CUSTID\tNAME\tADDRESS \t\tPHONE");
				while (rs.next()) {
					System.out.print("\t" + rs.getInt(1));
					System.out.print("\t" + rs.getString(2));
					System.out.print("\t\t" + rs.getString(3));
					System.out.println("\t" + rs.getString(4));
				}

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
 }

public class DB_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Booklist so=new Booklist();
	      so.sqlRun();
	      so.sqlRun2();

	}

}
