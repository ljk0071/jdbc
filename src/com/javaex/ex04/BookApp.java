package com.javaex.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		AuthorDao authordao = new AuthorDao();
		authordao.Drop();
		authordao.DropSeq();
		authordao.Create();
		authordao.CreateSeq();
		authorList.add(new AuthorVo("이문열", "다림"));
		authorList.add(new AuthorVo("박경리", "마로니에북스"));
		authorList.add(new AuthorVo("이고잉", "위키북스"));
		authorList.add(new AuthorVo("기안84", "중앙북스(books)"));
		authorList.add(new AuthorVo("강풀", "재미주의"));
		authorList.add(new AuthorVo("김영하", "문학동네"));
		for(int i=0;i<authorList.size();i++) {
			authordao.Insert(authorList.get(i));
		}
		BookDao bookdao = new BookDao();
		bookdao.Drop();
		bookdao.DropSeq();
		bookdao.Create();
		bookdao.CreateSeq();
		List<BookVo> bookList = new ArrayList<BookVo>();
		bookList.add(new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", "이문열"));
		bookList.add(new BookVo("삼국지", "민음사", "2002-03-01", "이문열"));
		bookList.add(new BookVo("토지", "마로니에북스", "2012-08-15", "박경리"));
		bookList.add(new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", "이고잉"));
		bookList.add(new BookVo("패션왕", "중앙북스(books)", "2012-02-22", "기안84"));
		bookList.add(new BookVo("순정만화", "재미주의", "2011-08-03", "강풀"));
		bookList.add(new BookVo("오직 두사람", "문학동네", "2017-05-04", "김영하"));
		bookList.add(new BookVo("26년", "재미주의", "2012-02-04", "강풀"));
		for(int i=0;i<bookList.size();i++) {
			bookdao.Insert(bookList.get(i));
		}
		System.out.println(bookdao.Select());
		System.out.print("검색어를 입력해 주세요: ");
		bookdao.Search(sc.nextLine());
		sc.close();
	}
}