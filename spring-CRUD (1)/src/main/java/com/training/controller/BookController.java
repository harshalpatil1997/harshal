package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.Book;
import com.training.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	           
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/Validate")
	public ModelAndView loginInfo(@RequestParam("uname") String uname,@RequestParam("upass") String upass)
	{
		boolean ans=bookService.loginInfo(uname,upass);
		if(ans)
		{
			System.out.println("Login Successfully !!");
			return new ModelAndView("redirect:/book");
			
		}
		else
		{
			String msg="Invalid Credential..!!";
			return new ModelAndView("redirect:/index","err",msg);
			
		}
	}
	@RequestMapping(value="/book")
	public ModelAndView showBook()
	{
		List<Book> list=bookService.showBook();
		return new ModelAndView("showbook","list",list);
	}
	
	@RequestMapping(value="/addBook")
	public ModelAndView addBookDetails(@RequestParam(value="id") int id,@RequestParam(value="name") String name,@RequestParam(value="pages")int pages)
	{
		Book b = new Book(id,name,pages);
		int ans=bookService.addBook(b);
		return new ModelAndView("redirect:/book");
		  //return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addBook()
	{
		return new ModelAndView("add","command",new Book());
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editBook(@PathVariable(value="id") int id)
	{
		Book b=bookService.getBookById(id);
		return new ModelAndView("EditBook","book",b);
	}
	
	
	
	@RequestMapping("/editBookDetails")
	public ModelAndView editBook(@RequestParam(value="bookid") int id,@RequestParam(value="bookname")String bookname,@RequestParam(value="numberofpages")int pages)
	{
		
		int ans=bookService.updateBook(id,bookname,pages);
		return new ModelAndView("redirect:/book");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteBook(@PathVariable(value="id")int id)
	{
		int ans=bookService.deleteBook(id);
		return new ModelAndView("redirect:/book");
	}


}
