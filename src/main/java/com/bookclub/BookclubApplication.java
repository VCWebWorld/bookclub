
/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022.
    Purpose: Main class for Bookclub Spring Boot application.
    
*/
package com.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookclubApplication {

/*
 * main method that starts Spring application 
 * @param args String[]
 */
	public static void main(String[] args) {
		SpringApplication.run(BookclubApplication.class, args); //Bootstaps Bookclub spring application
	} // end of main

} //end of BookclubApplication class
