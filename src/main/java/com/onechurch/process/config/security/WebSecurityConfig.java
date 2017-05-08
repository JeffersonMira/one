package com.onechurch.process.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by jeffe on 03/05/2017.
 */
//http://stackoverflow.com/questions/34453693/how-to-authenticate-login-logout-in-restful-web-application-in-spring
//http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
@EnableWebSecurity
@Configuration
@ComponentScan("com.onechurch")
class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                    .antMatchers("/public/**").permitAll() // allow any user to access public/
                    .anyRequest().fullyAuthenticated()  //for any other, it is necessary to authenticate
                .and()
                    .httpBasic()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .csrf();

//        http
//                .authorizeRequests()
//                .antMatchers("/assets/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .usernameParameter("j_username")
//                    .passwordParameter("j_password")
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/", true)
//                    .successHandler(customAuthenticationSuccessHandler)
//                    .permitAll()
//                .and()
//                    .logout()
//                    .logoutUrl("/logout")
//                    .invalidateHttpSession(true)
//                    .logoutSuccessUrl("/")
//                    .deleteCookies("JSESSIONID")
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .and()
//                    .csrf();
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("barry").password("password").roles("USER");
//    }

}