package com.springboot.assignmentdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/reports/list","reports/showFormForUpdate","reports/showFormForAdd","reports/delete").hasAnyRole("ADMIN")
                .antMatchers("/customers/list","customers/showFormForUpdate","customers/showFormForAdd","customers/delete").hasAnyRole("ADMIN")
                .antMatchers("/doctors/list","doctors/showFormForUpdate","doctors/showFormForAdd","doctors/delete").hasRole("ADMIN")
                .antMatchers("/customers/listNa","customers/showFormForUpdateNa","customers/viewReports").hasAnyRole("CUSTOMER")
                .antMatchers("/doctors/listNa","doctors/showFormForUpdateNa","doctors/viewPatients","doctors/viewReports").hasRole("DOCTOR")
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");;
    }
}