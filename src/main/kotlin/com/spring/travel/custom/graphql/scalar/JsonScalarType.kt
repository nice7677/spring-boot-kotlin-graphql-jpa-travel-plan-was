package com.spring.travel.custom.graphql.scalar

import com.google.gson.Gson
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component

@Component
class JsonScalarType : GraphQLScalarType("Json","Json", ObjectToJsonCoercing())

private class ObjectToJsonCoercing(): Coercing<Any, String> {


    @Suppress("UNCHECKED_CAST")
    private fun convenrtImpl(input: Any?): Any? {
        val gson = Gson()
        val json = gson.toJson(input)
        return json
    }

    override fun parseValue(input: Any?): Any? {
        return convenrtImpl(input)
    }

    override fun parseLiteral(input: Any?): Any? {
        return convenrtImpl(input)
    }

    override fun serialize(dataFetcherResult: Any?): String? {
        return convenrtImpl(dataFetcherResult).toString()
    }
}