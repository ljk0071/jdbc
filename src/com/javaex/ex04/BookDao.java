package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	private String id = "webdb";
	private String pw = "zmffp121";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private ResultSet rs = null;
	
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
	}
	public void Close() {
		try {
			if (rs != null) {
				rs.close();
			}
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        System.out.println("error:" + e);
	    }
	}
		
	public String Create() {
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			getConnection();
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "create table book(\r\n"
					+ "    book_id number(10)\r\n"
					+ "    ,title varchar2(100) not null\r\n"
					+ "    ,pubs varchar2(500)\r\n"
					+ "    ,pub_date date\r\n"
					+ "    ,author_name varchar2(50)\r\n"
					+ "    ,primary key(book_id)\r\n"
					+ "    ,constraint book_fk foreign key (author_name)\r\n"
					+ "    references author(author_name)\r\n)";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		Close();
		return "Book테이블 생성 완료";
	}
	
	public String Drop() {
		try {
		   getConnection();
			
			//SQL문 준비
			String query = ""; 
			query += "drop table book ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return "Book테이블 삭제 완료";
	}
	
	public String CreateSeq() {
		try {
		    getConnection();

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += ("create sequence seq_book_id\r\n"
					+ "increment by 1\r\n"
					+ "start with 1\r\n"
					+ "nocache");
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return "Book시퀀스 생성 완료";
	}
	
	public String DropSeq() {
		try {
		    getConnection();

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "drop sequence seq_book_id ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		}catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		Close();
		return "Book시퀀스 삭제 완료";
	}
	
	public int Insert(BookVo bookVo) {
		int count=0;
		
		try {
			getConnection();
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "insert into book ";
			query += "values(seq_book_id.nextval, ?, ?, ?, ?) ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubDate());
			pstmt.setString(4, bookVo.getAuthorName());
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 등록 되었습니다.");
		    
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return count;
	}
	
	
	public int DeleteAll() {
		int count=0;
		try {
		    getConnection();

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "delete from book ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 삭제 되었습니다.");
		    
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return count;
	}
	
	
	public int Delete(int bookId) {
		int count=0;
		try {
			getConnection();

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "delete from book ";
			query += "where book_id = ?";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setInt(1, bookId);
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 삭제 되었습니다.");
		    
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return count;
	}
	
	
	public List<BookVo> Select() {
		List<BookVo> bookList = new ArrayList<BookVo>();
		
		try {
			getConnection();
			
			String query = "";
			query += "select ";
			query += "book_id, title, pubs, pub_date, author_name ";
			query += "from book ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pubDate = rs.getString(4);
				String authorName = rs.getString(5);
				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorName);
				bookList.add(bookVo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		Close();
		return bookList;
	}
	
	public int Update(int bookId, String title, String pubs, String pubDate) {
		int count=0;
		try {
			getConnection();
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "update book ";
			query += "set title = ? ";
			query += ",pubs = ? ";
			query += ",pub_date = ? ";
			query += "where book_id = ? ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, bookId);
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 수정 되었습니다.");
		    
		    // 4.결과처리

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
		return count;
	}
	public void Search(String str) {
		
		List<BookVo> bookList = new ArrayList<BookVo>();
		try {
		    getConnection();

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += "select ";
			query += "book_id, title, pubs, pub_date, author_name ";
			query += "from book ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pubDate = rs.getString(4);
				String authorName = rs.getString(5);
				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorName);
				bookList.add(bookVo);
			}
			
			for(int i=0;i<bookList.size();i++) {
				if (bookList.get(i).toString().contains(str)) {
					System.out.println(bookList.get(i).toString());
				}
			}
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
	}
	public void Search(int num) {
		List<BookVo> bookList = new ArrayList<BookVo>();
		try {
			getConnection();
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += "select ";
			query += "book_id, title, pubs, pub_date, author_name ";
			query += "from book ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pubDate = rs.getString(4);
				String authorName = rs.getString(5);
				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorName);
				bookList.add(bookVo);
			}
			String num2 = num+"";
			for(int i=0;i<bookList.size();i++) {
				if (bookList.get(i).toString().contains(num2)) {
					System.out.println(bookList.get(i).toString());
				}
			}
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		Close();
	}
}
	


