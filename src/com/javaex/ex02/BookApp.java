package com.javaex.ex02;

public class BookApp {

	public static void main(String[] args) {
		
		BookVo bookvo = new BookVo("자서전", "사당", "2020/01/02", 1);
		BookDao bookdao = new BookDao();
		bookdao.Insert(bookvo);
		System.out.println(bookdao.Select());
		bookdao.Search("방배");
		
	}

}
