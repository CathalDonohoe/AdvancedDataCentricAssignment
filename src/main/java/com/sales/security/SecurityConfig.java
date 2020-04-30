package com.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Bean
public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
        .withUser("user")
        .password("user")
        .roles("ADMIN");
    
}

@Override
protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/").permitAll()
        .and()
        .formLogin();
    
    http
    .authorizeRequests()
    .antMatchers("/showProducts.html", "/showCustomers.html", "/showOrders.html","/addCustomer.html", "/addOrder.html", "/addProduct.html")
    .authenticated()
    .and()
    .formLogin();
}
}