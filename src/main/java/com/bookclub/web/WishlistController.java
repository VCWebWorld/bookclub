/*

    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: Wishlist controller class for Bookclub Spring Boot application.
   
*/

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/wishlist")  //maps web requests with /wishlist path to Spring Controller methods.
public class WishlistController {

    WishlistDao wishlistDao = new MongoWishlistDao();
    /**
     * Setter method for wishlistDao property variable
     * @param wishlistDao
     */
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    } //end setWishlistDao
    /**
     * showWishlist method  
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET) // maps base web request to showWishList method.
    public String showWishlist() {
        return "wishlist/list"; // return name of the HTML page to be rendered.
    } //end shwoWishlist
    /**
     * Method renders wishlist/new  page by returning its name
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new") // maps /wishlist/new web request to wishListForm method.
    public String wishlistForm(Model model) {
        
    	model.addAttribute("wishlistItem", new WishlistItem()); //assign WishlistItem variable to model attribute with object of WishlistItem"
        
    	return "wishlist/new"; // return name of the HTML page to be rendered.
    } //end wishlistForm()
    /**
     * addWishlistItem method adds wishlistItem to db
     * @param wishlistItem
     * @param bindingResult
     * @param authentication
     * @return String
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
       // System.out.println(wishlistItem.toString());
       // System.out.println("In WishlistController.java");
       //System.out.println(authentication.toString());
        wishlistItem.setUsername(authentication.getName()); // set username on wishlit item

        if (bindingResult.hasErrors()) { //bindingResult.hasErrors() is true
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem); // add the record to MongoDB

        return "redirect:/wishlist"; 
    } //end addWishlistItem()
    /**
     * ShowWishlistItem with given id 
     * @param id
     * @param model
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}") // maps GET request with path /{id} to showWishListItem method.
    public String showWishlistItem(@PathVariable String id, Model model) {
       
    	WishlistItem wishlistItem = wishlistDao.find(id); //call WishlistDao find method

        model.addAttribute("wishlistItem", wishlistItem); //Add results from find to model attribute as a key of wishlistitem

        return "wishlist/view"; //return name of the view to be rendered
    }//end ShowWishlistItem
   /**
    * Method to update wishlistitem
    * @param wishlistItem
    * @param bindingResult
    * @param authentication
    * @return String
    */
    @RequestMapping(method = RequestMethod.POST, path = "/update") // maps POST request with path /update to updateWishlistItem method. 
    public String updateWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
        
    	wishlistItem.setUsername(authentication.getName()); //set authentication - username

        if (bindingResult.hasErrors()) { //if binding result has errors true
            return "wishlist/view";   //return view to be rendered
        }
        wishlistDao.update(wishlistItem); 

        return "redirect:/wishlist"; //redirect to wishlist page
    } //end updateWishlistItem
    /**
     * Method to remove WishlistItem
     * @param id
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}") // maps GET request with path remove/{id} to removeWishListItem method.
    public String removeWishlistItem(@PathVariable String id) {

        wishlistDao.remove(id);

        return "redirect:/wishlist";  //return view to be rendered
    }//end removeWishlistItem
} //end WishlistController class