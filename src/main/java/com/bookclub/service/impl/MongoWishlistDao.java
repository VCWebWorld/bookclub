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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	 * @param WishlistItem
	 * @return void
	 */
	@Override
	public void update(WishlistItem entity) {
        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class); //find wishlistitem from mongodb for a given id 
        System.out.println( " In updae - MongoWishlistItem");
        
        if (wishlistItem != null) {
        	System.out.println( " In updae - MongoWishlistItem wishlistitem not null");
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setUsername(entity.getUsername()); //set wishlistitem object with values form input param

            mongoTemplate.save(wishlistItem); //save wishlistitem to mongodb.
        }
		
	}//end update()
    /**
     * Override method to remove Wishlistitem from db
     * @param String
     * @return boolean
     */
	@Override
	public boolean remove(String key) {
		Query query = new Query();

        query.addCriteria(Criteria.where("id").is(key)); //add query criteria

        mongoTemplate.remove(query, WishlistItem.class); //remove from mongodb for item matching given criteria

        return true;
	}//end remove()
    /**
     * Override method that returns list of Wishlistitems from db for specified query criteria
     * @param String
     * @return List<WishlistItem>
     */
	@Override
	public List<WishlistItem> list(String username) {
		Query query = new Query(); 
		query.addCriteria(Criteria.where("username").is(username)); //add query criteria for query object
		
		return mongoTemplate.find(query,WishlistItem.class); //call to mongotemplate find method to get list of wishlistitems
	}//end list()
    /**
     * Override method to find WishlistItem from db matching key
     * @return WishlistItem
     */
	@Override
	public WishlistItem find(String key) {
		
		return mongoTemplate.findById(key, WishlistItem.class);
	} //end find()
	
}// end MongoWishlistDao class
