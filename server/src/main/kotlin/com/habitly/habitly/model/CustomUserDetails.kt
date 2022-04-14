package com.habitly.habitly.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

open class CustomUserDetails(user: User) : User(user), UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles
            .stream()
            .map { role -> SimpleGrantedAuthority(role.roleName) }
            .collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return super.hashedPassword
    }

    override fun getUsername(): String {
        return super.userName
    }

    override fun isAccountNonExpired(): Boolean {
        return super.accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return super.accountNonLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return super.credentialsNonExpired
    }

    override fun isEnabled(): Boolean {
        return super.userIsEnabled
        // TODO
    }
}