/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: WishlistDao interface that extends GenericDao<WishlistItem, String> for Bookclub Spring Boot application.
    
*/
package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

/**
 *  An Data Access Object interface for WishlistItem extending GenericDao 
 *
 */
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {

}
