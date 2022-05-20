package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookUpdate {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "update book";
			query += " set title = ?";
			query += " ,pubs = ?";
			query += " ,pub_date = ?";
			query += " ,author_id = ?";
			query += " where book_id = ?";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setString(1, "달이 차오른다");           //?(물음표)중 1번쨰 -->순서중요
			pstmt.setString(2, "서울");         //?(물음표)중 2번쨰 -->순서중요
			pstmt.setString(3, "2020/12/12");
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 1);
			
			//실행
			int count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 수정 되었습니다.");
		    
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
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
	}

}
