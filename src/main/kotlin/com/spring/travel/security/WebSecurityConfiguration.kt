package com.spring.travel.security

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
open class WebSecurityConfiguration(): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        this.http.csrf().disable()
        this.http.authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {

    }
}