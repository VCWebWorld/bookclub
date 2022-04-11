/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: MemWishlistkDao class handles Data access layer for Wishlist object in Bookclub Spring Boot application.
    
*/
package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

/**
 * 
 * MemWishlistDao, a class representing data access object for WishlistItem, implementing WishlistDao interface
 *
 * */
public class MemWishlistDao implements WishlistDao {
	
	private List<WishlistItem> wishlist;

	/**
	 * MemoWishlistDao Constructor, This creates five book objects and add to private variable books list.
	 */
	public MemWishlistDao() {
		 this.wishlist = new ArrayList<WishlistItem>();
	     this.wishlist.add(new WishlistItem("9781609615543", "The Soil Will Save Us"));
	     this.wishlist.add(new WishlistItem("9780393608328", "Growing a Revolution: Bringing Our Soil Back to Life "));
	     this.wishlist.add(new WishlistItem("9798478955908", "Dirt to Soil"));
 	} //end of constructor

	/**
	 * list override method that returns list of WishListItems.
	 * @return List<WishlistItem>
	 */
	@Override
	public List<WishlistItem> list() {
		return this.wishlist;
	} //end of list()

	@Override
	public WishlistItem find(String Key) {
		for (WishlistItem item : this.wishlist) { //iterate through this.wishlistitem list 
			if (item.getIsbn().equals(Key)) { //check if isbn of the wishlititem matches key
				return item;  //return matching wishlistitem
			} //end if
		} //end for
		return new WishlistItem();
	} //end of find()

} //end class MemWishlistDao
