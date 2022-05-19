package com.bookclub;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
    @Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    /**
     * Test method for login
     * @throws Exception
     */
	@Test
	public void testlogin() throws Exception {
		mockMvc.perform(get("/login"))
		        .andDo(print())
		        .andExpect(status().isOk());
	}
	/**
	 * Test method for ShowWishlist
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void testShowWishlist() throws Exception {
		mockMvc.perform(get("/api/wishlist"))
			 	  .andDo(print())
		          .andExpect(status().isOk());
	}
	/**
	 * Test method to show monthly-books
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "Mytestuser01", password = "Mypassword01", roles = "ADMIN")
	public void testMonthlybookslist() throws Exception {
		mockMvc.perform(get("/monthly-books"))
			 	  .andDo(print())
		          .andExpect(status().isOk());
	}	
	     
}
