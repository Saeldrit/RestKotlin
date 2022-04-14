package ru.fortest.service

import ru.fortest.model.UserDto

interface UserService {
    fun getAll(): List<UserDto>
    fun addUser(userDto: UserDto): Int
    fun updateUser(id: Int, userDto: UserDto)
    fun deleteUserById(id: Int)
}
