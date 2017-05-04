package com.onechurch.process.config.security;

import com.onechurch.process.domain.User;
import com.onechurch.process.persistence.springjpa.UserPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by jeffe on 01/05/2017.
 */
@Configuration
@ComponentScan("com.onechurch")
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private UserPersistance userPersistance;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() throws UsernameNotFoundException {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                User user = userPersistance.findByName(username);

                if(user != null) {
                    return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                            true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                }else{
                    throw new UsernameNotFoundException("Not found user for '"+username+"'");
                }
            }
        };
    }

}
