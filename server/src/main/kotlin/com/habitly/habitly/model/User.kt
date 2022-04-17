package com.habitly.habitly.model

import Role
import javax.persistence.*

@Entity
open class User(
    var userName: String,
    var displayName: String,
    var email: String,
    var hashedPassword: String,
) {
    @Id
    @GeneratedValue
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var roles: Set<Role> = setOf(Role("ROLE_USER"))

    var accountNonExpired: Boolean = true
    var accountNonLocked: Boolean = true
    var credentialsNonExpired: Boolean = true
    var isLocked: Boolean = false
    var userIsEnabled: Boolean = true

    constructor(user: User) : this(user.userName, user.displayName, user.hashedPassword, user.email) {
        this.id = user.id
        this.userName = user.userName
        this.email = user.email
        this.hashedPassword = user.hashedPassword
        this.accountNonExpired = user.accountNonExpired
        this.accountNonLocked = user.accountNonLocked
        this.credentialsNonExpired = user.credentialsNonExpired
        this.roles = user.roles
        this.isLocked = user.isLocked
        this.userIsEnabled = user.userIsEnabled
    }
}