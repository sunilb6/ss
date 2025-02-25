package com.example.securesaving;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EmpSecurity {

    //----------------------------------------CRUD REST API----------------------------------//
    //In-memory
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails userDetails = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMP", "ADMIN")
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}marry123")
                .roles("EMP")
                .build();

        return new InMemoryUserDetailsManager(userDetails, marry);
    }*/

    /**
     * Fetch data from Table
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled from users where username=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/emp/**").hasRole("EMP"));

        //Use HTTP basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }*/

    //----------------------------------------END of CRUD REST API----------------------------------//
}
