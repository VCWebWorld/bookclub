/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: Home controller class for Bookclub Spring Boot application.
    
*/

package com.bookclub.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;

/**
 * HomeController class 
 **/
@Controller
@RequestMapping("/") //maps base web requests to Spring Controller methods.
public class HomeController
{
	 BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao(); 
	 /**
	  * Setter method for bookOfTheMonthDao property variable
	  * @param bookOfTheMonthDao
	  */
	 @Autowired
	 public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
	     this.bookOfTheMonthDao = bookOfTheMonthDao;
	 }
    /**
     * Method renders index (default home) page by returning its name
     * @param model
     * @param attributeName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET) // maps base web request to showHome method.
    public String showHome(Model model, String attributeName)
    {
        
    	Date date = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	int calMonth = cal.get(Calendar.MONTH)+ 1 ;
    	
    	RestBookDao bookDao = new RestBookDao(); //create RestBookDao object
    	List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));//map list from bookOfTheMonthDao.list to local monthlyBooks 
    	
    	StringBuilder isbnBuilder = new StringBuilder();
    	isbnBuilder.append("ISBN:");
    	
    	
    	
    	for (BookOfTheMonth monthlyBook : monthlyBooks) { //iterate through monthlyBooks list
    		isbnBuilder.append(monthlyBook.getIsbn()).append(","); //generate isbn sting 
    	}
    	
    	 String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);
    	 
    	 List<Book> books = bookDao.list(isbnString);
    	    	
    	model.addAttribute("books" , books); //assign books variable to model attribute with key "books"
       
    	return "index"; // return name of the HTML page to be rendered.
    } // end ShowHome()

    /**
     * Method that renders about page by returning its name when request path includes /about
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about") //maps web requests of type GET with path /about 
    public String showAboutUs(Model model)
    {
        return "about"; // return name of the html page to be rendered.
    } //end of showAboutUs()

    /**
     * Method that renders about page by returning its name when request path includes /contact
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact") //maps web requests of type GET with path /contact
    public String showContactUs(Model model)
    {
        return "contact"; // return name of the html page to be rendered.
    } //end of showContactUs()
   
    /** 
     * Method that renders monthly-books/view page by returning its name when request path /{id}. 
     * This method creates MemBookDao object and finds the Book object that matches input {id} variable and assigns found book object to model attribute with key "book".
     * @param id
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
    	
    	String isbn = id;
    	System.out.println(id);
    	
    	RestBookDao bookDao = new RestBookDao(); 
    	Book book = bookDao.find(isbn);
    	
    	System.out.println(book.toString());
    	
    	model.addAttribute("book", book);
    	return "monthly-books/view"; 
    }//end of getMonthlyBook()
    
      
} //end of HomeController class
