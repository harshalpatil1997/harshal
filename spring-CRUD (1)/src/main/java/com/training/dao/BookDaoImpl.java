package com.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.beans.Book;
import com.training.beans.MyUser;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean loginInfo(String uname, String upass) {
		
		String sql="select * from users where username=? and password=?";
		MyUser u=jdbcTemplate.queryForObject(sql,new Object[]{uname,upass},new RowMapper<MyUser>() {

			public MyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				MyUser u=new MyUser();
				u.setUname(rs.getString(1));
				u.setUpass(rs.getString(2));
				return u;
			}
		});
		if(u.getUname().equals(uname) && u.getUpass().equals(upass)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public List<Book> showAllBook() {
		String sql="select * from Book";
		List<Book> list=jdbcTemplate.query(sql,new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book b= new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setNumberofpages(rs.getInt(3));
				return b;
			}
			
		});
		return list;
	}

	@Override
	public int addByBook(Book b) {
		String sql="insert into Book values(?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {b.getBookid(),b.getBookname(),b.getNumberofpages()});
	}

	@Override
	public Book getBookById(int id) {
		String sql="select * from book where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book b= new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setNumberofpages(rs.getInt(3));
				return b;
			}
			
		});
		
	}

	@Override
	public int updateBook(int id, String bookname, int pages) {
		String sql="update book set name=?,numberofpages=? where id=?";
		return jdbcTemplate.update(sql,new Object[] {bookname,pages,id});
		
	}

	@Override
	public int deleteBook(int id) {
		String sql="delete from book where id=?";
		return jdbcTemplate.update(sql,new Object[]{id});
	}

}
