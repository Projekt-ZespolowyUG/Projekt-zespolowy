package com.pgs.soft.visit.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private LoginFailureHandler loginFailureHandler;
	
	@Autowired
	private LoginEntryPoint loginEntryPoint;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().authenticationEntryPoint(loginEntryPoint);
		http
			.csrf()
				.disable()
            .authorizeRequests()
                .antMatchers("/outpost/**", "/employee/**").authenticated()
                .antMatchers("/pages/**").permitAll()
                .and()
            .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .failureHandler(loginFailureHandler)
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/logout")
                .permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
        .withUser("user").password("password").roles("ROLE");
    }
} 