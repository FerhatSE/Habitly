package com.habitly.habitly.model

import Role
import javax.persistence.*

@Entity
open class User(
    var userName: String,
    var displayName: String,
    var email: String,
    var hashedPassword: String
) {
    @Id
    @GeneratedValue
    var id: Long = 0

    var accountNonExpired: Boolean = true
    var accountNonLocked: Boolean = true
    var credentialsNonExpired: Boolean = true
    var isLocked: Boolean = false
    var userIsEnabled: Boolean = true

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var roles: Set<Role> = HashSet()

    constructor(user: User) : this(user.userName, user.displayName, user.hashedPassword, user.email) {
        id = user.id
        userName = user.userName
        email = user.email
        hashedPassword = user.hashedPassword
        accountNonExpired = user.accountNonExpired
        accountNonLocked = user.accountNonLocked
        credentialsNonExpired = user.credentialsNonExpired
        roles = user.roles
        isLocked = user.isLocked
        userIsEnabled = user.userIsEnabled
    }
}