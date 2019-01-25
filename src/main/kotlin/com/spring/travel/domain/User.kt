package com.spring.travel.domain

import org.springframework.data.annotation.PersistenceConstructor
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user", schema = "public")
data class User @PersistenceConstructor constructor(

        @Id
        val id: String,
        val password: String,
        val name: String,
        val sex: String,
        val age: Int

)