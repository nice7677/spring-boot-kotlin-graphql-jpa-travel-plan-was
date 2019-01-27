package com.spring.travel.resolvers.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.travel.service.FriendPairService
import org.springframework.stereotype.Component

@Component
class FriendPairQueryResolver(
        private val friendPairService: FriendPairService
): GraphQLQueryResolver {

    fun findAllByUserFriend(user: String) = friendPairService.findAllByUserFriend(user)

}