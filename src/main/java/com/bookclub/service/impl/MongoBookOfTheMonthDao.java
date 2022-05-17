/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: MongoBookOfTheMonthDao class handles Data access layer for BookOfTheMonth object in Bookclub Spring Boot application.
    
*/
package com.bookclub.service.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;

/**
 * Class for MongoBookOfTheMonthDao
 *
 */
@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {
	
	@Autowired
    private MongoTemplate mongoTemplate; 

	/**
	 * Default constructor
	 */
	public MongoBookOfTheMonthDao() {
		// TODO Auto-generated constructor stub
	}
    /**
     * Method to add BookOfTheMonth to MongoDB
     * @param BookOfTheMonth
     */
	@Override
	public void add(BookOfTheMonth entity) {
		
		mongoTemplate.save(entity); //Save entity into mongoDB
	}//end of add
    /**
     * Method to update BookOfTheMonth
     * @param BookOfTheMonth
     */
	@Override
    public void update(BookOfTheMonth entity) {
        throw new NotImplementedException();
    }//end of update()
    /**
     * Method to remove item matching key
     * @param String
     * @return boolean
     */
    @Override
    public boolean remove(String key) {
        Query query = new Query(); //Create Query object

        query.addCriteria(Criteria.where("id").is(key)); //Add query criteria

        mongoTemplate.remove(query, BookOfTheMonth.class); //Remove from mongodb for item matching query criteria

        return true;
    }//end of remove()
    /**
     * list method that takes String key month and returns list of list from MongoDB BookOfthMonth
     * @param String 
     * @return List<BookOfTheMonth>
     */
    @Override
    public List<BookOfTheMonth> list(String key) {
        int month = Integer.parseInt(key);
        //System.out.println("in MongoBookOfMongh - list");
        //System.out.println("key: " + key);
        System.out.println("Month: " + month);

        if (month == 999) {
            return mongoTemplate.findAll(BookOfTheMonth.class); //find all 
        }

        Query query = new Query(); //Create Query object

        query.addCriteria(Criteria.where("month").is(month)); //Add Query criteria 

        return mongoTemplate.find(query, BookOfTheMonth.class); //find and return list of books for matching query 
    }//end of list()

    @Override
    public BookOfTheMonth find(String key) {
        throw new NotImplementedException();
    }//end of find

}
