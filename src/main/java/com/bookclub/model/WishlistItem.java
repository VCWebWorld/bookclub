/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: WishlistItem class provides template for an object representing WishlistItem for Bookclub Spring Boot application.
    
*/
package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

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
    @Id
	String id;
	
    private String username;

	/**
	 * Default constructor
	 */
	public WishlistItem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor that takes three parameters to set class private variables.
	 * @param isbn
	 * @param title
	 * @param username
	 */
	public WishlistItem(String isbn, String title, String username ) {
		this.isbn = isbn;
		this.title = title;
		System.out.println( "In WishlistItem constructor - username :" + username );
		this.username = username;
	}

	/**
	 * toString method which returns String representation of Wishlist object
	 * @return String
	 **/
	@Override
	public String toString() {
		return "WishlistItem {id=<\" + id + \">,isbn=<" + isbn + ">, title=<" + title + ">, username=<" + username + ">}";
	}
	
	 /** Getter method for id of WishlistItem object
	 * @return String
	 **/
	public String getId() {
		return id;
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
    /**
	 * Getter method for username of WishlistItem object
	 * @return String
	 **/
	public String getUsername() {
		System.out.println( "In WishlistItem  - get username :" + username );
		return username;
	}
    /**
     * Setter method for username of WishlistItem object
     * @param username
     */
	public void setUsername(String username) {
		System.out.println( "In WishlistItem  - in Setusername :" + username );
		this.username = username;
	} 
		

} //end class WishlistItem
