/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: WishlistItem class provides template for an object representing WishlistItem for Bookclub Spring Boot application.
    
*/
package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * WishlistItem class
 *
 */
public class WishlistItem {
	
	@NotNull
	@NotEmpty(message = "ISBN is a required field.")
	private String isbn;
	@NotNull
	@NotEmpty(message = "Title is a required field.")
	private String title;

	/**
	 * Default constructor
	 */
	public WishlistItem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor that takes two parameters to set class private variables.
	 * @param isbn
	 * @param title
	 */
	public WishlistItem(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	/**
	 * toString method which returns String representation of Wishlist object
	 * @return String
	 **/
	@Override
	public String toString() {
		return "WishlistItem {isbn=<" + isbn + ">, title=<" + title + ">}";
	}
		
	 /** Getter method for isbn of WishlistItem object
	 * @return String
	 **/
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Setter method for isbn of WishlistItem object
	 * @param String
	 **/	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	 /** Getter method for title of WishlistItem object
	 * @return String
	 **/
	public String getTitle() {
		return title;
	}
	
	/**
	 * Setter method for title of WishlistItem object
	 * @param String
	 **/
	public void setTitle(String title) {
		this.title = title;
	}
	
	

} //end class WishlistItem
