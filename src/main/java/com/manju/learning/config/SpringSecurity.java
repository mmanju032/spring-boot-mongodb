package com.manju.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	// this is for Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      PasswordEncoder encoder = 
      PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("user")
		.password(encoder.encode("user"))
		.roles("USER")
		.and()
		.withUser("admin")
		.password(encoder.encode("admin"))
		.roles("ADMIN");
	}

//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	@Bean
//	public PasswordEncoder getStdPasswordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
          .antMatchers("/admin/*").hasRole("ADMIN")
          .antMatchers("/user/*").hasAnyRole("ADMIN","USER")
          .antMatchers("/**").permitAll()
          .and().formLogin();
    }

}
