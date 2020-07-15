package com.autolease.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	
	

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	.and().csrf().disable()
	
//	"/login", , ,
//	"/confirmRegistration", "/bookNow",
//	, "/showBookingPage", "/finalBooking",
//	"/bookingDone", "/showMyBooking" "/loginSuccess"
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests()
//		.antMatchers("/",
//				"/showRegister","/processForm","/back",
//				"/backHome", "/css/**")
//		.permitAll()
//		.antMatchers("/login", "/confirmRegistration", "/bookNow",
//				"/showBookingPage", "/finalBooking",
//				"/bookingDone", "/showMyBooking", "/loginSuccess").hasAnyAuthority("USER", "ADMIN")
//		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.anyRequest().authenticated().and()
//		.formLogin()
//		.loginPage("/showLogin")
//		.loginProcessingUrl("/login")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll()
//		.and()
//		.exceptionHandling().accessDeniedPage("/access-denied");
		
//		http.authorizeRequests().antMatchers("/", "/showRegister", 
//				"/processForm", "/back", "/login", "/css/**", 
//				"/confirmRegistration","/showLogin", "/backHome", 
//				"/showBookingPage", "/finalBooking", "/bookingDone",
//				"/showMyBooking", "/loginSuccess").permitAll()
//		.antMatchers("/admin/*").hasAnyAuthority("ADMIN")
//		.anyRequest().authenticated().and().csrf().disable();
		
//		http.authorizeRequests()
//		.anyRequest().authenticated()
//		.and().formLogin()
//		.loginPage("/showLogin")
//		.loginProcessingUrl("/login")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll();
		
		http.authorizeRequests()
		.antMatchers("/",
				"/showRegister","/processForm","/back",
				"/backHome", "/css/**").permitAll()
		.antMatchers("/user/**", "/loginSuccess").authenticated()
		.and().formLogin()
		.loginPage("/showLogin")
		.loginProcessingUrl("/login")
		.permitAll()
		.and()
		.logout();
//		.logoutUrl("/backHome")
//		.invalidateHttpSession(true)
//		.deleteCookies("JSESSIONID");
//		.permitAll();
	}
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	 

}
