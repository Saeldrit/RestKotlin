package ru.fortest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForTestApplication

fun main(args: Array<String>) {
    runApplication<ForTestApplication>(*args)
}
