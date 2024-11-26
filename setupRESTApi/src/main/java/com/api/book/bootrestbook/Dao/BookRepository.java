package com.api.book.bootrestbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.Book;

public interface BookRepository  extends CrudRepository<USER,Integer>{
	public USER findById(int id);
	
	

}
