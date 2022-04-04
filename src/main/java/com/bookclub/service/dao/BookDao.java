/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: BookDao interface that extends GenericDao<Book, String> for Bookclub Spring Boot application.
    
*/

package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

public interface BookDao extends GenericDao<Book, String> {

}
