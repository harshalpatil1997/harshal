package com.training.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.beans.Book;
import com.training.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> showBook() {
		return bookDao.showAllBook();
	
	}

	@Override
		public int addBook(Book b) {
			
			return bookDao.addByBook(b);
			
		}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public int updateBook(int id, String bookname, int pages) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(id,bookname,pages);
	}

	@Override
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(id);
	}

	@Override
	public boolean loginInfo(String uname, String upass) {
		return bookDao.loginInfo(uname,upass);
	}
		
	}

