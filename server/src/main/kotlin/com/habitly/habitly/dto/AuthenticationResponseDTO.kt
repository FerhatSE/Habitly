package com.habitly.habitly.dto

class AuthenticationResponseDTO(
    val id: Number,
    val username: String,
    val displayName: String,
    val jwtToken: String
)