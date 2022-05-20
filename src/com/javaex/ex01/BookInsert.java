package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookInsert {

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
			int count = 0;
			ArrayList<String> ql = new ArrayList<String>();
			ql.add("insert into book ");
			ql.add("values( seq_book_id.nextval, '우리들의 일그러진 영웅', '다림', '1998-02-22', 1) ");
			ql.add("values( seq_book_id.nextval, '삼국지', '민음사', '2002-03-01', 1) ");
			ql.add("values( seq_book_id.nextval, '토지', '마로니에북스', '2012-08-15', 2) ");
			ql.add("values( seq_book_id.nextval, '유시민의 글쓰기 특강', '생각의길', '2015-04-01', 3) ");
			ql.add("values( seq_book_id.nextval, '패션왕', '중앙북스(books)', '2012-02-22', 4) ");
			ql.add("values( seq_book_id.nextval, '순정만화', '재미주의', '2011-08-03', 5) ");
			ql.add("values( seq_book_id.nextval, '오직두사람', '문학동네', '2017-05-04', 6) ");
			ql.add("values( seq_book_id.nextval, '26년', '재미주의', '2012-02-04', 5) ");
			for(int i=1; i<ql.size();i++) {
				pstmt = conn.prepareStatement(ql.get(0)+ql.get(i)); //문자열을 쿼리로 만들기
				count += pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			}
			
			//실행
			
			System.out.println(count + "건이 등록 되었습니다.");

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
