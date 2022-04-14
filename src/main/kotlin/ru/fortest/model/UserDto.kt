package ru.fortest.model

data class UserDto(
    val id: Int? = null,
    val eMail: String,
    val firstName: String,
    val lastName: String,
    val secondName: String,
    val phoneNumber: Long
)
