package ru.fortest.model.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    var eMail: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var secondName: String = "",
    var phoneNumber: Long = 0L
)
