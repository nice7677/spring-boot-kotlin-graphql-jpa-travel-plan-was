package com.spring.travel.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.travel.service.UserService
import org.springframework.stereotype.Component

@Component
class UserResolver(private val userService: UserService): GraphQLQueryResolver {

    fun findByIdUser(id: String) = userService.findById(id)

    fun findAllUser() = userService.findAll()

    fun login(id: String, password: String) = userService.login(id, password)

}