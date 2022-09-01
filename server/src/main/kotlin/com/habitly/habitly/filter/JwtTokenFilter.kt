package com.habitly.habitly.filter

import com.habitly.habitly.service.CustomUserDetailsService
import com.habitly.habitly.util.JwtTokenUtil
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtTokenUtil: JwtTokenUtil,
    private val userDetailsService: CustomUserDetailsService
) :
    OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        print("Reached JWT Token filter")
        val authorizationHeader = request.getHeader("Authorization")

        var username: String? = null
        val jwt: String?

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7)
            username = jwtTokenUtil.extractUsername(jwt)
        }

        if (username.isNullOrEmpty() && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userDetailsService.loadUserByUsername(username)

            val usernamePasswordAuthenticationToken =
                UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

            usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
        }
        filterChain.doFilter(request, response)
    }
}