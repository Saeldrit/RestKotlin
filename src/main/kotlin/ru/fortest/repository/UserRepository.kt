package ru.fortest.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.fortest.model.entity.User

interface UserRepository : JpaRepository<User, Int> {
}