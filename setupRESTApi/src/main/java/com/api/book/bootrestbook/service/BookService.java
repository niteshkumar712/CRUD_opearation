package com.api.book.bootrestbook.service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(12,"C Langage"," DennisRitchie"));
//		list.add(new Book(124,"Python Langage"," Van De Rousoom"));
//		list.add(new Book(128,"DBMS"," Navathe"));
//		list.add(new Book(125,"Dicrete Mathematics","Kenneth Rosen"));
//		
//	}
	/*----------------------------------------------------------------------*/
	
		//GET ALL BOOKS
public List<Book> GetAllBooks(){
				List<Book> list=(List<Book>)this.bookRepository.findAll();
				return list ;
	}

/*----------------------------------------------------------------------*/
//GET SINGLE BOOK 
	public Book getBookById(int id ) {
		Book book=null;
//		list.stream().filter(e->e.getId()==id).findFirst().get();
		book=this.bookRepository.findById(id);
		
		return book;		
	}
	/*----------------------------------------------------------------------*/
	//ADDING BOOKS
	public Book addBook(Book b) {
		Book result=bookRepository.save(b);
		return result;
		
	}
	
	/*----------------------------------------------------------------------*/
	//DELETING BOOK BY ID 
	public void  deletebooks(int bid) {
		
//		 list =list.stream().filter(book-> {
//			
//			if(book.getId()!=bid) {
//				return true;
//			}else {
//				return false;
//			}
//			
//		}).collect(Collectors.toList());
		
		bookRepository.deleteById(bid);
		
		
		
		
		}
	
	/*----------------------------------------------------------------------*/
	// UPDATING BOOK BY ID
	public void updateBooks(Book book, int bid) {
//		list=list.stream().map(b->{
//			if(b.getId()==bid) {
//				b.setAuthor(book.getAuthor());
//				b.setTittle(book.getTittle());
//				
//			}
//			return b;
//			
//			
//			
//		}).collect(Collectors.toList());
		
		
		book.setId(bid);
		bookRepository.save(book);
		
		
		
		
		
	}
	

	
	
}
