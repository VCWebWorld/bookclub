/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: WishlistRestController class using REST for Bookclub Spring Boot application.
    
*/
package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {
	
    WishlistDao wishlistDao = new MongoWishlistDao();

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

/**
 * showWishlist method returns list of wishlist items from mongodb
 * @param Authentication
 * @return List<WishlistItem>
 */
    @RequestMapping(method = RequestMethod.GET) //maps base web request to showWishlist method
    public List<WishlistItem> showWishlist(Authentication authentication) { 
    
    	String username = authentication.getName(); //bind username with authentication object's name property
        
    	return wishlistDao.list(username);
    } //end showWishlist
    /**
     * findByID method 
     * @param id
     * @return WishlistItem
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET) //maps base web request with path /{id} to findById method
    public WishlistItem findById(@PathVariable String id) {
        
    	return wishlistDao.find(id); //call to wishlistDao find method with passed in id
    
    } //end findById
} //end WislistRestController 