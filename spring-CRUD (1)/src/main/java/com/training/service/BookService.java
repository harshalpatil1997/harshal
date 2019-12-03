package com.training.service;

import java.util.List;

import com.training.beans.Book;

public interface BookService {

	boolean loginInfo(String uname, String upass);
	List<Book> showBook();
	int addBook(Book b);
	Book getBookById(int id);
	int updateBook(int id, String bookname, int pages);
	int deleteBook(int id);
}
