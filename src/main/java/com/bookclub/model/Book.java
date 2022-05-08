/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: Book class provides template for an object representing book for Bookclub Spring Boot application.
    
*/
package com.bookclub.model;

/**
 * This is a class to represent a book
 *
 **/
public class Book { 
	
	private String isbn; //Stores ISBN of the Book
	private String title; // Stores Book title 
	private String description; //Stores Book description
	private String infoUrl; //Stores infoUrl
	private int numOfPages; //Stores number of Pages in Book

	/**
	 * Default constructor 
	 **/
	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that takes five parameters to set class private variables 
	 * @param isbn
	 * @param title
	 * @param description
	 * @param numOfPages
	 **/
	public Book( String isbn, String title, String description, String infoUrl, int numOfPages ) {
		
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.infoUrl = infoUrl;
		this.numOfPages = numOfPages;

	}
	
    /**
     * 
     * @param isbn
     * @param title
     * @param infoUrl
     */
	public Book(String isbn, String title, String infoUrl) {
		
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
	}

	/**
	 * toString method which returns String representation of Book object
	 * @return String
	 **/
	@Override
	public String toString() {
		return "Book {isbn=<" + isbn + ">, title=<" + title + ">, description=<" + description + ">, infoUrl=<" + infoUrl + ">, numOfPages=<" + numOfPages
				+ ">}";
	}
	/**
	 * Getter method for isbn of Book object
	 * @return String
	 **/
	public String getIsbn() {
		return isbn; //return isbn property of the Book
	}
	/**
	 * Setter method for isbn of Book object
	 * @param String
	 **/
	public void setIsbn(String isbn) {
		this.isbn = isbn; //set isbn property of the Book
	}
	/**
	 * Getter method for title of Book object
	 * @return String
	 **/
	public String getTitle() {
		return title; //return title property of the Book
	}
	/**
	 * Setter method for title of Book object
	 * @param String
	 **/
	public void setTitle(String title) {
		this.title = title; //set title property of the Book
	}
	/** Getter method for isbn of Book object
	 * @return String
	 **/
	public String getDescription() {
		return description; //return description property of the Book
	}
	/**
	 * Setter method for description of Book object
	 * @param String
	 */
	public void setDescription(String description) {
		this.description = description; //set description property of the Book
	}
	/**
	 * Getter method for infoUrl of the Book object
	 * @return String
	 **/
	public String getInfoUrl() {
		return infoUrl; //return infoUrl property of the Book
	}
	/**
	 * Setter method for infoUrl of the Book object
	 * @param String
	 **/
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl; //set infoUrl property of the Book
	}
	/**
	/** Getter method for numOfPages of Book object
	 * @return int
	 **/	
	public int getNumOfPages() {
		return numOfPages; //return numOfPages property of the Book
	}
	/**
	 * Setter method for numOfPages of Book object
	 * @param int
	 */
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages; //set numOfPages property of the Book
	}
	/** Getter method for authors of Book object
	 * @return List<string>
	 **/
	/*public List<String> getAuthors() {
		return authors; //return authors property of the Book
	} */
	/**
	 * Setter methhod for authors of Book object
	 * @param List<String>
	 */
	/*public void setAuthors(List<String> authors) {
		this.authors = authors; //set authors property of the Book
	}*/
	
	
	
} //end of Book class
