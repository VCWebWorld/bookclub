/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: Home controller class for Bookclub Spring Boot application.
    
*/

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author F90GYYL
 *
 */
@Controller
@RequestMapping("/") //maps base web requests to Spring Controller methods.
public class HomeController
{
	/*
	 * Method renders index (default home) page by returning its name
	 */
    @RequestMapping(method = RequestMethod.GET) // maps base web request to showHome method.
    public String showHome(Model model)
    {
        return "index"; // return name of the html page to be renderd.
    } // end ShowHome

    /*
	 * Method thatrenders about page by returning its name 
	 * when request path includes /about
	 */
    @RequestMapping(method = RequestMethod.GET, path = "/about") //maps web requests of type GET with path /about 
    public String showAboutUs(Model model)
    {
        return "about"; // return name of the html page to be rendered.
    } //end of showAboutUs

    /*
	 * Method that renders about page by returning its name 
	 * when request path includes /contact
	 */
    @RequestMapping(method = RequestMethod.GET, path = "/contact") //maps web requests of type GET with path /contact
    public String showContactUs(Model model)
    {
        return "contact"; // return name of the html page to be rendered.
    } //end of showContactUs
} //end of HomeController class
