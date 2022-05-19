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