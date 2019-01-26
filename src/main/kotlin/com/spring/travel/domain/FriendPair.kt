package com.spring.travel.domain

import org.springframework.data.annotation.PersistenceConstructor
import javax.persistence.*

@Entity
@Table(name = "friend_pair", schema = "public")
data class FriendPair @PersistenceConstructor constructor(

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val idx: Int,
        @Column(name = "user_id")
        val userId: String,
        val friend: String

)