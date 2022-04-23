package com.habitly.habitly.model.user

data class UserDTO(
    val username: String,
    val displayName: String,
    val email: String,
    val password: String
)