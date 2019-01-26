package com.spring.travel.service

import com.spring.travel.domain.User
import com.spring.travel.exception.ExceptionHandler
import com.spring.travel.exception.ExceptionObject
import com.spring.travel.repository.UserRepository
import org.springframework.stereotype.Service
import sun.security.util.Password

@Service
class UserService(
        private val userRepository: UserRepository
) {

    val jobType: String = "User"

    fun findById(id: String) = userRepository.findById(id).get()

    fun findAll() = userRepository.findAll()

    fun creatUser(id: String, password: String, name: String, sex: String, age: Int) =
        userRepository.save(User(id = id, password = password, name = name, sex = sex, age = age))

    fun updateUser(id: String, password: String, name: String, sex: String, age: Int) =
        userRepository.save(User(id=id, password = password, name = name, sex = sex, age = age))

    fun deleteUser(id: String, password: String): ExceptionObject {
        if (userRepository.findByIdAndPassword(id, password).isPresent) {
            userRepository.deleteById(id)
            return ExceptionHandler().state(jobType,"delete user","success")
        }
        else {
            return ExceptionHandler().state(jobType, "delete user","failed")
        }
    }

}