/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: BookofTheMonth class provides template for an object representing book of the month object for Bookclub Spring Boot application.
    
*/

package com.bookclub.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

/**
 * This is a class to represents Book of the Month 
 *
 **/
public class BookOfTheMonth {
	@Id
	String id; //Stores id
	
	Integer month; //Stores month 
	
	@NotEmpty(message = "ISBN can not be Empty. It is a required field")
	String isbn; //Stores ISBN of the book of the month
	
    /**
     * Default constructor
     */
	public BookOfTheMonth() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor that takes two parameters to set class private variables 
	 * @param month
	 * @param isbn
	 */
    public BookOfTheMonth(int month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    } 

	/**
	 * toString method which returns String representation of BookOfTheMonth object
	 * @return String
	 **/
	@Override
	public String toString() {
		return "BookOfTheMonth [id=" + id + ", isbn=" + isbn + ", month=" + month + "]";
	} //end toString()


	/**
	 * Getter method for id of BookOfTheMonth object
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Setter method for id of BookOfTheMonth object
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Getter method for month of BookOfTheMonth object
	 * @return the month
	 */
	public Integer getMonth() {
		return month;
	}


	/**
	 * Setter method for month of BookOfTheMonth object
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}


	/**
	 * Getter method for isbn of BookOfTheMonth object
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * Setter method for isbn of BookOfTheMonth object
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	

}//end of Class BookOfTheMonth
