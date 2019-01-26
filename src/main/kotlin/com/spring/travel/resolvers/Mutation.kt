package com.spring.travel.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.travel.service.FriendPairService
import com.spring.travel.service.UserService
import org.springframework.stereotype.Component

@Component
class Mutation (
    private val userService: UserService,
    private val friendPairService: FriendPairService
    ): GraphQLMutationResolver {
    fun createUser(id: String, password: String, name: String, sex: String, age: Int) = userService.creatUser(id, password, name, sex, age)
    fun updateUser(id: String, password: String, name: String, sex: String, age: Int) = userService.updateUser(id, password, name, sex, age)
    fun deleteUser(id: String, password: String) = userService.deleteUser(id, password)
    fun addFriend(user: String, friend: String) = friendPairService.addFriend(user, friend)
    fun deleteFriend(user: String, friend: String) = friendPairService.deleteFriend(user, friend)

}