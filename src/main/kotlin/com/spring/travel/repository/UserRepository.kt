package com.spring.travel.repository

import com.spring.travel.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {

    override fun findById(id: String): Optional<User>

    override fun deleteById(id: String)

    fun findByIdAndPassword(id: String, password: String): Optional<User>

}