package com.spring.travel.custom

class ResultVM {

    fun success(type: String, action: String): ResultVMObject {
        return ResultVMObject(type, action,true, type + " " + action + " " + "Success")
    }

    fun failure(type: String, action: String): ResultVMObject {
        return ResultVMObject(type, action,false, type + " " + action + " " + "Failure")
    }

}

data class ResultVMObject constructor(
        private val type: String,
        private val action: String,
        private val success: Boolean,
        private val message: String
)

