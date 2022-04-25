/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
	rights reserved. 
    Modified by V. Chukkaluru 2022. 
    Purpose: SecurityConfig class handles  for Bookclub Spring Boot application.
    
*/

package com.bookclub.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class handling authorization and authentication for Bookclub application. 
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * Override configure method handling in-memory authentication with password encoding. 
	 * Method defines two user in-memory user configurations.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder =  PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    
		auth
		    .inMemoryAuthentication() //allows to create in-memory user configurations
		    .withUser("user").password(encoder.encode("password")).roles("USER") //starts in memory user configuration with given user name and password
		    .and()
		    .withUser("Mytestuser").password(encoder.encode("Mypassword")).roles("USER", "ADMIN"); //starts in memory user configuration with given user name and password
		
	} //end configure() - authentication

	/**
	 * Override Configure method handling authorization for Bookclub application
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http
		    .authorizeRequests()   
		        .anyRequest().authenticated()   //allow access to authenticated users
		        .and()
		    .formLogin() 
		        .loginPage("/login")  //allow form login page access 
		        .permitAll()          //permitted to all users  
		        .and()
		    .logout()
		        .logoutSuccessUrl("/login?logout=true")  
		        .invalidateHttpSession(true)   //invalidat3e session before after logout
		        .permitAll();                  //permit logout page access to all authenticated users   
		        	
	} //end configrue() - authentication
	
	

}
