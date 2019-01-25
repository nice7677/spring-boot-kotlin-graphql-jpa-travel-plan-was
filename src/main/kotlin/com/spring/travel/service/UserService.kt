package com.spring.travel.service

import com.spring.travel.domain.User
import com.spring.travel.repository.UserRepository
import org.springframework.stereotype.Service
import sun.security.util.Password

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun findById(id: String) = userRepository.findById(id).get()

    fun findAll() = userRepository.findAll()

    fun creatUser(id: String, password: String, name: String, sex: String, age: Int) =
        userRepository.save(User(id = id, password = password, name = name, sex = sex, age = age))


}