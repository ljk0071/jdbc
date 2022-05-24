package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
	
	
	public String Create() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "create table author(\r\n"
					+ "    author_id number(10)\r\n"
					+ "    ,author_name varchar2(100) not null\r\n"
					+ "    ,author_desc varchar2(500)\r\n"
					+ "    ,primary key(author_name)\r\n"
					+ ")";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return "Author테이블 생성 완료";
	}
	
	public String Drop() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "drop table author ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return "Author테이블 삭제 완료";
	}
	
	public String CreateSeq() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += ("create sequence seq_author_id\r\n"
					+ "increment by 1\r\n"
					+ "start with 1\r\n"
					+ "nocache");
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return "Author시퀀스 생성 완료";
	}
	
	public String DropSeq() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "drop sequence seq_author_id ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			pstmt.executeUpdate();
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return "Author시퀀스 삭제 완료";
	}
	
	public int Insert(AuthorVo authorVo) {
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "insert into author ";
			query += "values(seq_author_id.nextval, ?, ?) ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 등록 되었습니다.");
		    
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return count;
	}
	
	
	public int DeleteAll() {
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "delete from author ";
			query += "";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 삭제 되었습니다.");
		    
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return count;
	}
	
	
	public int Delete(int authorId) {
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "delete from author ";
			query += "where author_id = ?";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setInt(1, authorId);
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 삭제 되었습니다.");
		    
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return count;
	}
	
	
	public List<AuthorVo> Select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url ,"webdb", "zmffp121");
			
			String query = "";
			query += "select ";
			query += "author_id, author_name, author_desc ";
			query += "from author ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				authorList.add(authorVo);
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
		return authorList;
	}
	
	
	public int Update(int authorId, String authorName, String authorDesc) {
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = ""; 
			query += "update author ";
			query += "set author_name = ? ";
			query += ",author_desc = ? ";
			query += "where author_id = ? ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); //문자열을 쿼리로 만들기
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			pstmt.setInt(3, authorId);
			
			//실행
			count = pstmt.executeUpdate();                //쿼리문 실행 -->리턴값으로 성공갯수
			System.out.println(count + "건이 수정 되었습니다.");
		    
		    // 4.결과처리

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return count;
	}
	public void Search(String str) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += "select ";
			query += "author_id, author_name, author_desc ";
			query += "from book ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				authorList.add(authorVo);
			}
			for(int i=0;i<authorList.size();i++) {
				if (authorList.get(i).toString().contains(str)) {
					System.out.println(authorList.get(i).toString());
				}
			}
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		    	if  (rs != null) {
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
	public void Search(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "zmffp121");

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += "select ";
			query += "author_id, author_name, author_desc ";
			query += "from book ";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				authorList.add(authorVo);
			}
			String num2 = num+"";
			for(int i=0;i<authorList.size();i++) {
				if (authorList.get(i).toString().contains(num2)) {
					System.out.println(authorList.get(i).toString());
				}
			}
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		    	if  (rs != null) {
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
	


