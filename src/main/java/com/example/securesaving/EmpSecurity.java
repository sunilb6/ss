package com.example.securesaving;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
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
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails userDetails = User.builder()
                .username("sanji")
                .password("{noop}test123")
                .roles("EMP")
                .build();

        UserDetails marry = User.builder()
                .username("luffy")
                .password("{noop}test123")
                .roles("LEADER", "EMP")
                .build();

        UserDetails manager = User.builder()
                .username("zoro")
                .password("{noop}test123")
                .roles("EMP")
                .build();

        return new InMemoryUserDetailsManager(userDetails, marry, manager);
    }

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    .requestMatchers("/").hasRole("EMP")
                    .requestMatchers("/leaders/**").hasRole("LEADER")
                    .anyRequest().authenticated();
        }).formLogin(form->
                //TODO: No need to write any Controller for /authTheUser, but you have to write for /login
                //TODO authTheUser will be handled by Spring Security Filters
                form
                        .loginPage("/showLogin")
                        .loginProcessingUrl("/authTheUser")
                        .permitAll()
        ).logout(LogoutConfigurer::permitAll)
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer -> {
                    //TODO: We can call this /access-denied anything , we like
                    httpSecurityExceptionHandlingConfigurer.accessDeniedPage("/access-denied");
                });

        //Use HTTP basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
