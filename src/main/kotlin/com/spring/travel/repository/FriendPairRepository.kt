package com.spring.travel.repository

import com.spring.travel.domain.FriendPair
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendPairRepository : JpaRepository<FriendPair, Int> {

    fun findAllByUserId(user: String): List<FriendPair>

    fun findByUserIdAndFriend(user: String, friend: String): FriendPair

}