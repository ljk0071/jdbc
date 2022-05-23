package com.javaex.ex02;

public class BookVo {
	
	public int bookId, authorId;
	public String title, pubs, pubDate;
	
	public BookVo(String title, String pubs, String pubDate, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}
	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}
	public BookVo(int bookId, String title, String pubs, String pubDate) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	
	public BookVo(String title, String pubs, String pubDate) {
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", authorId=" + authorId + ", title=" + title + ", pubs=" + pubs
				+ ", pubDate=" + pubDate + "]";
	}
	
	

}
