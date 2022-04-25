/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: SecurityController class for Bookclub Spring Boot application.
    
*/
package com.bookclub.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Security Controller class for Bookclub application
 *
 */
@Controller 
public class SecurityController  {
	/**
	 *  Method maps requests with path /login and renders login page by returning its name
     * @return String
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	} //end ShowLoginPage()
	/**
	 * Method maps requests with path /logout and renders login page by returning its name
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication(); //get Authentication object from SecurityContext
	   
	   if (auth != null) {
		   new SecurityContextLogoutHandler().logout(request, response, auth); 
	   }
	   return "redirect:/login?logout=true";
	} //end logout()

	
} //end SecurityController class
