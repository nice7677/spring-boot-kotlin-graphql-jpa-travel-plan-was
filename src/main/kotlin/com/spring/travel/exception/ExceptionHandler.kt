package com.spring.travel.exception

import org.springframework.context.MessageSource

class ExceptionHandler {

    //todo Exception handler need modify
    // 사실 Exception handler 처음 만들어봄ㅋㅋ

    fun state(type: String, action: String, message: String): ExceptionObject {
        return ExceptionObject(type=type, action = action, message = message)
    }

}

data class ExceptionObject constructor(
        val type: String,
        val action: String,
        val message: String
)