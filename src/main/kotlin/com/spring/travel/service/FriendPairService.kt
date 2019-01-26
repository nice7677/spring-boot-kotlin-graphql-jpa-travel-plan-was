package com.spring.travel.service

import com.spring.travel.domain.FriendPair
import com.spring.travel.exception.ExceptionHandler
import com.spring.travel.exception.ExceptionObject
import com.spring.travel.repository.FriendPairRepository
import org.springframework.stereotype.Service

@Service
class FriendPairService(
    private val friendPairRepository: FriendPairRepository
) {

    val jobType: String = "Friend"

    fun findAllByUserFriend(id: String) = friendPairRepository.findAllByUserId(id)

    fun addFriend(user: String, friend: String): ExceptionObject {
        try {
            friendPairRepository.save(FriendPair(0,user, friend))
            friendPairRepository.save(FriendPair(0,friend, user))
            return ExceptionHandler().state(jobType, "add friend","success")
        } catch (e: Exception) {
            return ExceptionHandler().state(jobType, "add friend","failed")
        }
    }

    fun deleteFriend(user: String, friend: String): ExceptionObject {
        try {
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(user, friend))
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(friend, user))
            return ExceptionHandler().state(jobType, "delete friend","success")
        } catch (e: Exception) {
            return ExceptionHandler().state(jobType, "delete friend","failed")
        }
    }

}