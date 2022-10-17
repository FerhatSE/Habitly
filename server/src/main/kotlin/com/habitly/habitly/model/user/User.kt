package com.habitly.habitly.model.user

import com.habitly.habitly.annotation.AllOpenAnnotation
import com.habitly.habitly.model.Role
import com.habitly.habitly.model.project.Project
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*

@Entity
@AllOpenAnnotation
class User(
    var userName: String,
    val displayName: String,
    var hashedPassword: String,

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = [CascadeType.ALL])
    var roles: MutableList<Role> = mutableListOf(),

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var accountNonExpired: Boolean = true
    var accountNonLocked: Boolean = true
    var credentialsNonExpired: Boolean = true
    var isLocked: Boolean = false
    var userIsEnabled: Boolean = true

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = [CascadeType.ALL])
    var projects: MutableList<Project> = mutableListOf()

    constructor(user: User) : this(
        user.userName,
        user.displayName,
        user.hashedPassword,
        user.roles
    ) {
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