package com.mjm.springcloud.security.config;

import com.mjm.springcloud.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/productapi/products/{id}","/index", "/showGetProduct","/getProduct","/productDetails")
                .hasAnyRole("USER","ADMIN")
                .mvcMatchers(HttpMethod.GET, "/showCreateProduct","/CreateProduct", "/createResponse")
                .hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/getProduct")
                .hasAnyRole("USER","ADMIN")
                .mvcMatchers(HttpMethod.POST, "/productapi/products","/saveProduct","/getProduct")
                .hasRole("ADMIN")
                .mvcMatchers("/","/login","showReg", "/registerUser").permitAll()
                .anyRequest().denyAll().and().csrf().disable()
                .logout().logoutSuccessUrl("/");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
