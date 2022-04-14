package ru.fortest.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.fortest.model.UserDto
import ru.fortest.model.entity.User
import ru.fortest.repository.UserRepository

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getAll(): List<UserDto> {
        return userRepository.findAll()
            .map { it.toDto() }
    }

    override fun addUser(userDto: UserDto): Int {
        return userRepository.save(userDto.toEntity()).id
    }

    override fun updateUser(id: Int, userDto: UserDto) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User Not found")

        existingUser.eMail = userDto.eMail
        existingUser.firstName = userDto.firstName
        existingUser.lastName = userDto.lastName
        existingUser.secondName = userDto.secondName
        existingUser.phoneNumber = userDto.phoneNumber

        userRepository.save(existingUser)
    }

    override fun deleteUserById(id: Int) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User Not found")

        userRepository.deleteById(existingUser.id)
    }

    private fun User.toDto(): UserDto =
        UserDto(
            id = this.id,
            eMail = this.eMail,
            firstName = this.firstName,
            lastName = this.lastName,
            secondName = this.secondName,
            phoneNumber = this.phoneNumber
        )

    private fun UserDto.toEntity(): User =
        User(
            id = 0,
            eMail = this.eMail,
            firstName = this.firstName,
            lastName = this.lastName,
            secondName = this.secondName,
            phoneNumber = this.phoneNumber
        )
}
