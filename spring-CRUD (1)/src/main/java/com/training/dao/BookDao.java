package com.training.dao;

import java.util.List;

import com.training.beans.Book;

public interface BookDao {

	List<Book> showAllBook();

	int addByBook(Book b);

	Book getBookById(int id);

	int updateBook(int id, String bookname, int pages);

	int deleteBook(int id);

	boolean loginInfo(String uname, String upass);

}
