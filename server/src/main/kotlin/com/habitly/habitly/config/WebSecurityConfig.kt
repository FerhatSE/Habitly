package com.habitly.habitly.config

import com.habitly.habitly.filter.JwtTokenFilter
import com.habitly.habitly.service.CustomUserDetailsService
import com.habitly.habitly.util.JwtTokenUtil
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*


@EnableWebSecurity
@Configuration
class WebSecurityConfiguration(
    private var customUserDetailsService: CustomUserDetailsService,
    private var jwtTokenUtil: JwtTokenUtil
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun jwtTokenFilterRegistrationBean(): FilterRegistrationBean<JwtTokenFilter> {
        val frb = FilterRegistrationBean(JwtTokenFilter(jwtTokenUtil, customUserDetailsService))
        frb.isEnabled = false
        return frb
    }

    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.authorizeRequests().antMatchers("/auth/**").permitAll()
        http.authorizeRequests().anyRequest().authenticated()
        http.formLogin().loginPage("/auth/login")
        http.addFilterBefore(
            jwtTokenFilterRegistrationBean().filter,
            UsernamePasswordAuthenticationFilter::class.java
        )
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder())
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/auth/**")
    }
}
