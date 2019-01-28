package com.spring.travel.service

import com.spring.travel.domain.FriendPair
import com.spring.travel.custom.vm.ResultVM
import com.spring.travel.custom.vm.ResultVMHandler
import com.spring.travel.repository.FriendPairRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FriendPairService(
    private val friendPairRepository: FriendPairRepository
) {

    val jobType: String = "Friend"

    fun findAllByUserFriend(id: String) = friendPairRepository.findAllByUserId(id)

    //todo idx value need update
    fun addFriend(user: String, friend: String): ResultVM {
        try {
            friendPairRepository.save(FriendPair(0,user, friend))
            friendPairRepository.save(FriendPair(0,friend, user))
            return ResultVMHandler().success(jobType, "Add", friendPairRepository.findByUserIdAndFriend(user, friend))
        } catch (e: Exception) {
            return ResultVMHandler().failure(jobType, "Add", null)
        }
    }

    fun deleteFriend(user: String, friend: String): ResultVM {
        try {
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(user, friend))
            friendPairRepository.delete(friendPairRepository.findByUserIdAndFriend(friend, user))
            return ResultVMHandler().success(jobType, "Delete", null)
        } catch (e: Exception) {
            return ResultVMHandler().failure(jobType, "Delete", null)
        }
    }

}