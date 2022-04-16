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
	 * 
	 */
	public MongoWishlistDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(WishlistItem entity) {
		mongoTemplate.save(entity);
	}

	@Override
	public void update(WishlistItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(WishlistItem entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WishlistItem> list() {
		return mongoTemplate.findAll(WishlistItem.class);
	}

	@Override
	public WishlistItem find(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
