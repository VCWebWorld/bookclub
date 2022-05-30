/*
   Testing the web layer. Spring. (n.d.). Retrieved from 
   https://spring.io/guides/gs/testing-web/
   Modified By: Vani Chukkaluru
   Created Date: 05/19/2022
   Modified Date: 05/29/2022
   Purpose: Adding unit tests to BookClub application 
*/


package com.bookclub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	/**
	 * TestHttpReq method
	 * @throws Exception
	 */
	@Test
	public void testHttpReq() throws Exception {
		
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Bookclub");
	}
	

}
