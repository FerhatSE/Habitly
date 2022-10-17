package com.habitly.habitly.model.project

enum class ColorTheme {
    RANDOM, BLUE, GREEN, PURPLE, RED, DARK;

    fun getTheme(colorCode: String) {
        val colorTheme = when (colorCode) {
            "blue" -> BLUE;
            "green" -> GREEN
            "purple" -> PURPLE;
            "red" -> RED
            "dark" -> DARK;
            else -> RANDOM
        }
    }
}