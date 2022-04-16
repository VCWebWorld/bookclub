/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: GenericCrudDao interface providing set of specifications for methods to be implemented by classes that implement this interface for Bookclub Spring Boot application.
    
*/

package com.bookclub.service;

import java.util.List;

public interface GenericCrudDao <E, K> {
	void add(E entity); // Add object to list
	void update(E entity); // Update object in list
	boolean remove(E entity); // Remove object from list
	List<E> list(); // Return a list of objects of type E.
	E find(K Key); // Return an object of type E by type K value.

}
