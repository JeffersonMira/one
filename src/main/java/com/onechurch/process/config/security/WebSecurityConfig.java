package com.onechurch.process.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Created by jeffe on 03/05/2017.
 */
//http://stackoverflow.com/questions/34453693/how-to-authenticate-login-logout-in-restful-web-application-in-spring
//http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
@EnableWebSecurity
@Configuration
@ComponentScan("com.onechurch")
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //CORS!!!!!
    //https://spring.io/understanding/CORS
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                    .antMatchers("/public/**").permitAll() // allow any user to access public/
//                    .anyRequest().fullyAuthenticated()  //for any other, it is necessary to authenticate
                        .anyRequest().permitAll()
                .and()
                    .httpBasic()
                .and()
                    .cors()
                .and()
                    .csrf().disable();
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("barry").password("password").roles("USER");
//    }

}