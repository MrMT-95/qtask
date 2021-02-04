package com.company.qtask.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Configuration
@Service
@EnableWebSecurity
public class EncoderServiceImpl extends WebSecurityConfigurerAdapter implements EncoderService {

    DataSource dataSource;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


    //enable JDBC authentication
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder());
//    }
//
//    @Bean
//    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        return jdbcUserDetailsManager;
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable();
    }
}


