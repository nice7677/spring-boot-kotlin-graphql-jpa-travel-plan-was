package com.spring.travel.service

import com.spring.travel.domain.FriendPair
import com.spring.travel.custom.ResultVM
import com.spring.travel.custom.ResultVMObject
import com.spring.travel.repository.FriendPairRepository
import org.springframework.stereotype.Service

@Service
class FriendPairService(
    private val friendPairRepository: FriendPairRepository
) {

    val jobType: String = "Friend"

    fun findAllByUserFriend(id: String) = friendPairRepository.findAllByUserId(id)

    //todo idx value need update
    fun addFriend(user: String, friend: String): ResultVMObject {
        try {
            friendPairRepository.save(FriendPair(0,user, friend))
            friendPairRepository.save(FriendPair(0,friend, user))
            return ResultVM().success(jobType, "Add")
        } catch (e: Exception) {
            return ResultVM().failure(jobType, "Add")
        }
    }

    fun deleteFriend(user: String, friend: String): ResultVMObject {
        try {
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(user, friend))
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(friend, user))
            return ResultVM().success(jobType, "Delete")
        } catch (e: Exception) {
            return ResultVM().failure(jobType, "Delete")
        }
    }

}