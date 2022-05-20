package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectALL {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url ,"webdb", "zmffp121");
			
			String query = "";
			query += "select ";
			query += "book_id, title, pubs, pub_date, a.author_id, author_name, author_desc ";
			query += "from book b, author a ";
			query += "where a.author_id = b.author_id";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				int authorId = rs.getInt("author_id");
//				String authorName = rs.getString("author_name");
//				String authorDesc = rs.getString("author_desc");
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pubDate = rs.getString(4);
				String authorId = rs.getString(5);
				String authorName = rs.getString(6);
				String authorDesc = rs.getString(7);
				System.out.println(bookId + ", " + title + ", " + pubs + ", " + pubDate + ", " 
				+ authorId + ", " + authorName + ", " + authorDesc);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt !=null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" +e);
			}
		}

	}

}
