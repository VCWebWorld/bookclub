/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: MongoWishlistkDao class handles Data access layer for Wishlist object in Bookclub Spring Boot application.
    
*/

package com.bookclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

/**
 * 
 * MemWishlistDao, a class representing data access object for WishlistItem, implementing WishlistDao interface
 *
 * */
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Default constructor
	 */
	public MongoWishlistDao() {
		// TODO Auto-generated constructor stub
	} //end constructor
    /**
     * Override method to add Wishlistitem into db.
     */
	@Override
	public void add(WishlistItem entity) {
		mongoTemplate.save(entity); //save Wishlistitem into db
	} //end add()

	/**
	 * Override method to update WishlistItem 
	 */
	@Override
	public void update(WishlistItem entity) {
		// TODO Auto-generated method stub
		
	}
    /**
     * Override method to remove Wishlistitem from db
     * @return boolean
     */
	@Override
	public boolean remove(WishlistItem entity) {
		// TODO Auto-generated method stub
		return false;
	}
    /**
     * Override method that returns list of Wishlistitems from db
     * @return List<WishlistItem>
     */
	@Override
	public List<WishlistItem> list() {
		return mongoTemplate.findAll(WishlistItem.class);
	}
    /**
     * Override method to find WishlistItem from db matching key
     * @return WishlistItem
     */
	@Override
	public WishlistItem find(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
