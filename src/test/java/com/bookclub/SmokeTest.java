/*
   Testing the web layer. Spring. (n.d.). Retrieved from 
   https://spring.io/guides/gs/testing-web/
   Modified By: Vani Chukkaluru
   Created Date: 05/19/2022
   Modified Date: 05/29/2022
   Purpose: Adding unit tests to BookClub application 
*/

package com.bookclub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookclub.web.HomeController;
import com.bookclub.web.WishlistController;
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private HomeController controller;
	@Autowired
	private WishlistController wishlistController;
	
	/**
	 * Test method to test HomeController and WishlistController
	 * @throws Exception
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull(); //assert HomeController 
		assertThat(wishlistController).isNotNull(); //assert WishlistController
	}
	

}
