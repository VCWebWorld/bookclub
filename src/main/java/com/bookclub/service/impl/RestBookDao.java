/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: MemBookDao class handles Data access layer for Bookclub Spring Boot application.
    
*/
package com.bookclub.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * MemBookDao, a class representing data access object for Book, implementing BookDao interface
 *
 **/
public class RestBookDao implements BookDao {

	/**
     * MemoBookDao Constructor
	 **/
	public RestBookDao() {
   
	    } //end of constructor
		

    /**
     * Override list method, which calls getBookDoc method with sting of isbn numbers of books to get list of books
     * @return List<Book>
     */
	@Override
    public List<Book> list() {
        String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";

        Object doc = getBooksDoc(isbnString);  // call getBooksDoc that invokes third party open API call

        List<Book> books = new ArrayList<Book>();

        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index))); //add details of books from json doc to book List
        }

        return books;
    }
    /**
     *find(String) override method that returns a book object matching given key.
     *@return Book
     */
    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key); //call getBooksDoc to get make API call to get info on the boo

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        Book book = new Book(isbn, title, desc, infoUrl, numOfPages); //create new Book object

        return book;
        
    }
	
  /**
   * Method sends HttpGet request to the OpenLibraryAPI returns Json document object with 
   * @param isbnString
   * @return Object
   */
	private Object getBooksDoc(String isbnString) {
    	String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate(); // call the RestTemplate object to invoke a third-party API call.

        HttpHeaders headers = new HttpHeaders();
        
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");    //Create UriComponentBuilder object with url for api and queryparms

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(      
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);  //call to exchange method of RestTemplate object with Http GET method.

        String jsonBooklist = response.getBody();  // bind response body to jsonBooklist variable.

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }

} //end of RestBookDao class
