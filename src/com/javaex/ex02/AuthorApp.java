package com.javaex.ex02;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		AuthorVo authorVo = new AuthorVo("예아", "베이비");
		
		authorDao.Insert(authorVo);
		System.out.println(authorDao.Select());
		
		
	}
}
