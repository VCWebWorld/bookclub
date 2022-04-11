/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: Wishlist controller class for Bookclub Spring Boot application.
    
*/
package com.bookclub.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;
/**
 * WishlistController class 
 **/
@Controller
@RequestMapping("/wishlist") //maps web requests with /wishlist path to Spring Controller methods.
public class WishlistController {

	/**
	 * default constructor
	 */
	public WishlistController() {
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Method renders wishlist/list  page by returning its name
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET) // maps base web request to showWishList method.
    public String showWishlist(Model model) {
    
    	MemWishlistDao wishlistDao = new MemWishlistDao(); //create MemWishlistDao object
    	
    	List<WishlistItem> wishlist = wishlistDao.list(); //map book list returned from bookDao.list() to local books list
    	
    	model.addAttribute("wishlist", wishlist); //assign wishlist object to model attribute with key "wishlist"
       
    	return "wishlist/list"; // return name of the HTML page to be rendered.
    } // end ShowWishlist()

    /**
     * Method renders wishlist/new  page by returning its name
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, path ="/new") // maps /wishlist/new web request to wishListForm method.
    public String wishlistForm(Model model) {
    	
    	model.addAttribute("wishlistItem", new WishlistItem()); //assign WishlistItem variable to model attribute with object of WishlistItem"
		
    	return "wishlist/new"; // return name of the HTML page to be rendered.
    } //end wishlistForm()
    
    /**
     * 
     * @param wishlistItem
     * @param bindingResults
     * @return
     */
    @RequestMapping( method = RequestMethod.POST)
    public String addWishlistItem ( @Valid WishlistItem wishlistItem, BindingResult bindingResults) {
    	
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResults.getAllErrors());
    	
    	if (bindingResults.hasErrors()) { //bindingResult.hasErrors() is true
    	   return "wishlist/new"; 
    	}
    	
    	return "redirect:/wishlist";
    	
    	
    } //end addWishListItem()

} //end of class WishlistController
