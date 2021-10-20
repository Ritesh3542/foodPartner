package com.project.foodPartner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.foodPartner.service.FoodUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	FoodUserDetailsService myUserDetailsService;

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder(10);
   }
    

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http.cors();
	   http
	   .csrf().disable()
       .authorizeRequests()
           .antMatchers( "/foodUser/**").permitAll()
           .antMatchers("/check/**").hasRole("CUSTOMER")
           .anyRequest().fullyAuthenticated()
           .and()
       .httpBasic()
           .and()
       .logout()
        .logoutUrl("/logout")
           .logoutSuccessUrl("/")
           .permitAll();

   }

   
}