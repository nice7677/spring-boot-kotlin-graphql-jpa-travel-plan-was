package com.spring.travel.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.travel.repository.UserRepository
import com.spring.travel.service.UserService
import org.springframework.stereotype.Component

@Component
class UserResolver(private val userService: UserService, private val userRepository: UserRepository): GraphQLQueryResolver {

    fun findById(id: String) = userService.findById(id)

    fun findAllUser() = userService.findAll()

}