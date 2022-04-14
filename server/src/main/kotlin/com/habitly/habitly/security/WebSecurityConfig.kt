package com.habitly.habitly.security

import com.habitly.habitly.service.CustomUserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class WebSecurityConfiguration(
    private val customUserDetailsService: CustomUserDetailsService,
    private val passwordEncoderAndMatcher: PasswordEncoder,
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
            .antMatchers("/api/v1/*").authenticated()
            .anyRequest().permitAll().and()
            .formLogin().loginPage("/api/v1/login")
            .and().logout().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoderAndMatcher)
    }
}