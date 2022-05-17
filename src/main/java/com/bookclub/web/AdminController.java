/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: AdminController class for Bookclub Spring Boot application.
   
*/

package com.bookclub.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;

@Controller
@RequestMapping("/monthly-books") //maps web requests with /monthly-books path to Spring Controller methods.
public class AdminController {
	
	BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();
    /**
     * Default Constructor
     */
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Setter method for bookOfTheMonthDao property variable
     * @param bookOfTheMonthDao
     */
    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }
    /**
     * ShowBookOfTheMonth method to show list of the books of the month
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET) // maps base get web request from monthly-books page to showBookOfTheMonth method.
    public String showBookOfTheMonth(Model model) {
    	
        model.addAttribute("books", bookOfTheMonthDao.list("999")); //maps books model attribute bookoftheMonth list
        return "monthly-books/list"; //return page to be rendered.
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET) // maps monthly-books/new web requests to bookOfTheMonthForm method.
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths()); 
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
        return "monthly-books/new"; //return name of the HTML page to be rendered
    }

    @RequestMapping(method = RequestMethod.POST) //map post web request from monthly-books page to addBookOfTheMonth method
    public String addBookOfTheMonth(@Valid BookOfTheMonth bookOfTheMonth, BindingResult bindingResult, Model model) {
        System.out.println(bookOfTheMonth.toString());

        if (bindingResult.hasErrors()) { //bindingResult.hasErrors() is true
            model.addAttribute("months", getMonths()); //map months attribute to map returned from getMonths method
            return "monthly-books/new"; //return name of the HTML page to be rendered
        }

        bookOfTheMonthDao.add(bookOfTheMonth); //add record to MongoDB via Dao

        return "redirect:/monthly-books";//redirect to monthly-books HTML page to be rendered
    }
    /**
     * Method to remove Book of the month with given {id}
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String removeBookOfTheMonth(@PathVariable String id) {
        bookOfTheMonthDao.remove(id); //remove record with mathching id

        return "redirect:/monthly-books"; //redirect to monthly-books HTML page to be rendered
    }
    /**
     * Method that populates Map <Integer, String> with numeric and text values of month name
     * @return Map<Integer, String>
     */
    private Map<Integer, String> getMonths() {
        Map<Integer, String> months = new HashMap<>(); 
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        return months;
    }//end of getMonths()

}//end of AdminController class
