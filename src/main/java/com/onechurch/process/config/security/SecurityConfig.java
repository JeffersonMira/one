package com.onechurch.process.config.security;

import com.onechurch.process.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@EnableGlobalMethodSecurity(prePostEnabled = true) //it is necessary to make the @PreAuthorize works
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


   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic() //Authentication is done sending user/password in the6 header
              .and()
              .csrf().disable();
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