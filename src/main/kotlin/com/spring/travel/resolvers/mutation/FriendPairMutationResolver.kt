package com.spring.travel.resolvers.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.travel.service.FriendPairService
import org.springframework.stereotype.Component

@Component
class FriendPairMutationResolver(
        private val friendPairService: FriendPairService
) : GraphQLMutationResolver {

    fun addFriend(user: String, friend: String) = friendPairService.addFriend(user, friend)

    fun deleteFriend(user: String, friend: String) = friendPairService.deleteFriend(user, friend)

}