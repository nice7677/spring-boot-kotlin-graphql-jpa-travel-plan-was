package com.spring.travel.custom.vm

import com.google.gson.Gson
import org.springframework.boot.configurationprocessor.json.JSONObject

class ResultVMHandler {

    fun success(type: String, action: String, responseVM: Any?): ResultVM {
        return ResultVM(type, action, true, type + " " + action + " " + "Success", responseVM)
    }

    fun failure(type: String, action: String, responseVM: Any?): ResultVM {
        return ResultVM(type, action, false, type + " " + action + " " + "Failure", responseVM)
    }

}

data class ResultVM constructor(
        private val type: String,
        private val action: String,
        private val success: Boolean,
        private val message: String,
        private val responseVM: Any?
)

