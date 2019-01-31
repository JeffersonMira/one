package com.onechurch.process.config.security;

import com.onechurch.process.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Created by jeffe on 03/05/2017.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
        //it is necessary to make the @PreAuthorize works
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    //CORS!!!!!
    //https://spring.io/understanding/CORS
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowCredentials(true);
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedHeader("*"); // necessary to receive the CORS when a request is done. POST
//        configuration.addAllowedMethod("*");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }


    //CONFIGURATION USED WHEN THE TOKEN IS NOT NECESSARY. IN THIS CASE ALL THE REQUESTS
    //MUST SEND THE USER/PASSWORD IN THE HEADER.
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//      http.authorizeRequests()
////              .anyRequest()
////              .authenticated()             // this will disable the SpringSecurity
//              .antMatchers("/*/users/**").hasRole("USER")
//              .antMatchers("/*/admin/**").hasRole("ADMIN")
//              .and()
//              .httpBasic() //Authentication is done sending user/password in the6 header
//              .and()
//              .csrf().disable();
//   }


    /*
    * Including the filters that crate and validate the tokens.
    * Clients can call <application>/login passing the values as a json:
    * { "username":"name",
    *   "password":"password"
    * }
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, SecurityConstants.SIGN_UP_URL).permitAll()
                .antMatchers("/*/users/**").hasRole("USER")
                .antMatchers("/*/admin/**").hasRole("ADMIN")
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAutorizationFilter(authenticationManager(), customUserDetailsService));

    }

//   Implementation used for inmemory authentication - not using the db data
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//      auth.inMemoryAuthentication()
//              .withUser("jeff").password("abc123").roles("USER")
//              .and()
//              .withUser("admin").password("secure").roles("USER", "ADMIN");
//   }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}