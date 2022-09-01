package com.habitly.habitly.model.user

import com.habitly.habitly.annotation.AllOpenAnnotation
import com.habitly.habitly.model.Role
import javax.persistence.*

@Entity
@AllOpenAnnotation
@Table(name = "user")
class User(
    var userName: String,
    val displayName: String,
    var hashedPassword: String,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    ) var roles: MutableList<Role> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var accountNonExpired: Boolean = true
    var accountNonLocked: Boolean = true
    var credentialsNonExpired: Boolean = true
    var isLocked: Boolean = false
    var userIsEnabled: Boolean = true

    constructor(user: User) : this(
        user.userName,
        user.displayName,
        user.hashedPassword,
        user.roles
    ) {
        user.id.also { this.id = it }
        user.userName.also { this.userName = it }
        user.hashedPassword.also { this.hashedPassword = it }
        user.accountNonExpired.also { this.accountNonExpired = it }
        user.accountNonLocked.also { this.accountNonLocked = it }
        user.credentialsNonExpired.also { this.credentialsNonExpired = it }
        user.roles.also { this.roles = it }
        user.isLocked.also { this.isLocked = it }
        user.userIsEnabled.also { this.userIsEnabled = it }
    }
}