package com.spring.travel.custom

class ResultVMHandler {

    fun success(type: String, action: String): ResultVM {
        return ResultVM(type, action,true, type + " " + action + " " + "Success")
    }

    fun failure(type: String, action: String): ResultVM {
        return ResultVM(type, action,false, type + " " + action + " " + "Failure")
    }

}

data class ResultVM constructor(
        private val type: String,
        private val action: String,
        private val success: Boolean,
        private val message: String
)

