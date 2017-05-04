package com.onechurch.process.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jeffe on 03/05/2017.
 */

@EnableWebSecurity
@Configuration
@ComponentScan("com.onechurch")
class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

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