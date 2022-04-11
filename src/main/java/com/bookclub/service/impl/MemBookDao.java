/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: MemBookDao class handles Data access layer for Bookclub Spring Boot application.
    
*/
package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

/**
 * MemBookDao, a class representing data access object for Book, implementing BookDao interface
 *
 **/
public class MemBookDao implements BookDao {
	private List<Book> books;

    /**
     * MemoBookDao Constructor, This creates five book objects and add to private variable books list.
	 **/
	public MemBookDao() {
		 this.books = new ArrayList<Book>();
	     this.books.add(new Book("0345339681", "The Hobbit", "Bilbo Baggins was a hobbit who wanted to be left alone in quiet comfort. But the wizard Gandalf came along with a band of homeless dwarves. Soon Bilbo was drawn into their quest, facing evil orcs, savage wolves, giant spiders, and worse unknown dangers. Finally, it was Bilbo–alone and unaided–who had to confront the great dragon Smaug, the terror of an entire countryside", 322, new ArrayList<>(List.of("J.R.R. Tolkien"))));
	     this.books.add(new Book("0261103571", "The Fellowship of the Ring", "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them", 432, new ArrayList<>(List.of("J.R.R. Tolkien"))));
	     this.books.add(new Book("1514297272", "The Two Towers", "The second volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS", 448, new ArrayList<>(List.of("J.R.R. Tolkien"))));
	     this.books.add(new Book("1514298139", "The Return of the King", "The third volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS", 432, new ArrayList<>(List.of("J.R.R. Tolkien"))));
	     this.books.add(new Book("9780593099322", "Dune", "A deluxe hardcover edition of Frank Herbert’s epic masterpiece—a triumph of the imagination and one of the bestselling science fiction novels of all time.", 688, new ArrayList<>(List.of("J.R.R. Tolkien"))));
		
	    } //end of constructor
		
	
	/**
	 * list override method that returns list of books.
	 * @return List<Book>
	 */
	@Override
	public List<Book> list() {
		
		return this.books;  
	} //end of list()

    /**
     *find(String) override method that returns a book object matching given key.
     *@return Book
     */
	@Override
	public Book find(String Key) {
		for (Book book : this.books) { //iterate through this.books list 
			if (book.getIsbn().equals(Key)) { //check if isbn of the book matches key
				return book;  //return matching book
			} //end if
		} //end for
		return new Book();
	} //end of find()

} //end of BooDao class
