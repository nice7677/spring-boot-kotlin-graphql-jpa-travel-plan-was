package com.spring.travel.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.travel.service.UserService
import org.springframework.stereotype.Component

@Component
class Mutation (
    private val userService: UserService
    ): GraphQLMutationResolver {
    fun createUser(id: String, password: String, name: String, sex: String, age: Int) = userService.creatUser(id, password, name, sex, age)
}