package ru.fortest.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import ru.fortest.model.UserDto
import ru.fortest.service.UserService

@RestController
@Api(description = "Карта пользователей")
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @ApiOperation("Список пользователей")
    @GetMapping
    fun getAll(): List<UserDto> = userService.getAll()

    @ApiOperation("Добавление нового пользователя")
    @PostMapping
    fun add(@RequestBody userDto: UserDto): Int {
        return userService.addUser(userDto);
    }

    @ApiOperation("Обновление данных о пользователе")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody userDto: UserDto
    ) {
        userService.updateUser(id, userDto)
    }

    @ApiOperation("Удаление пользователя")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) {
        userService.deleteUserById(id)
    }
}
