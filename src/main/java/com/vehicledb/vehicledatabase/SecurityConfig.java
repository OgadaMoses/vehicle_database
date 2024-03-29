package com.vehicledb.vehicledatabase;

import java.util.Arrays;

import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.vehicledb.vehicledatabase.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
 @Autowired
 private UserDetailsServiceImpl userDetailsService;
 
 @Autowired
 private AuthenticationFilter authenticationFilter;
 
 // inject the AuthEntryPoint class
  @Autowired
  private AuthEntryPoint exceptionHandler;
 
 @Autowired
	 public void configureGlobal
	 (AuthenticationManagerBuilder auth)
	  throws Exception {
	 auth.userDetailsService(userDetailsService)
	 .passwordEncoder (new BCryptPasswordEncoder ());
 }
   @Bean
   public AuthenticationManager getAuthenticationManager () throws
   Exception {
	   return authenticationManager();
   }
   
   @Override 
   protected void configure(HttpSecurity http) throws  Exception {
	   http.csrf() .disable().cors() .and()
	   .sessionManagement()
	   .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and ()
	   .authorizeRequests()
	   .antMatchers(HttpMethod.POST, "/login").permitAll()
	   .anyRequest() .authenticated() .and()
	   .exceptionHandling()
	   .authenticationEntryPoint(exceptionHandler).and ()
	   .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	   
   }
   // add cross-origin resource sharing
   
   
  @Bean
   CorsConfigurationSource corsConfigurationSource () {
	   UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	   CorsConfiguration config = new CorsConfiguration();
	   config.setAllowedOrigins(Arrays.asList("http:localhost:3000")); 
	   config.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
	   config.setAllowedHeaders(Arrays.asList("http:localhost:3000"));
	   config.setAllowCredentials(false);
	   config.applyPermitDefaultValues();
	   
	  source.registerCorsConfiguration("/**", config);
	  return source;
	  
   } 
}
