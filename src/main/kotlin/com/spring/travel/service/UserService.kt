package com.spring.travel.service

import com.spring.travel.domain.User
import com.spring.travel.custom.ResultVM
import com.spring.travel.custom.ResultVMHandler
import com.spring.travel.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    val jobType: String = "User"

    fun findById(id: String) = userRepository.findById(id).get()

    fun findAll() = userRepository.findAll()

    fun login(id: String, password: String): ResultVM {

        if (passwordEncoder.matches(password, userRepository.findById(id).get().password)) {
            return ResultVMHandler().success(jobType, "Login")
        }
        else {
            return ResultVMHandler().failure(jobType, "Login")
        }

    }

    fun creatUser(id: String, password: String, name: String, sex: String, age: Int): ResultVM {

        if (userRepository.findById(id).isPresent) {
            return ResultVMHandler().failure(jobType, "Create")
        }
        else {
            userRepository.save(User(id = id, password = passwordEncoder.encode(password), name = name, sex = sex, age = age))
            return ResultVMHandler().success(jobType, "Create")
        }

    }

    fun updateUser(id: String, password: String, name: String, sex: String, age: Int) =
            userRepository.save(User(id = id, password = password, name = name, sex = sex, age = age))

    fun deleteUser(id: String, password: String): ResultVM {
        if (userRepository.findByIdAndPassword(id, password).isPresent) {
            userRepository.deleteById(id)
            return ResultVMHandler().success(jobType, "Delete")
        } else {
            return ResultVMHandler().failure(jobType, "Delete")
        }
    }

}

